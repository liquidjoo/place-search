package com.github.liquidjoo.placesearch.local.place.infra;

import com.github.liquidjoo.placesearch.local.place.application.PlaceResponse;
import com.github.liquidjoo.placesearch.local.place.domain.Keyword;
import com.github.liquidjoo.placesearch.local.place.domain.Searchable;
import com.github.liquidjoo.placesearch.search.kakao.place.application.KakaoAddressService;
import com.github.liquidjoo.placesearch.search.kakao.place.domain.Document;
import com.github.liquidjoo.placesearch.search.kakao.place.domain.Documents;
import com.github.liquidjoo.placesearch.search.kakao.place.domain.Meta;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlaceSearchable implements Searchable {

    private static final String DAUM_MAP_LINK = "https://map.kakao.com/link/map/%s";

    private final KakaoAddressService kakaoAddressService;

    public PlaceSearchable(final KakaoAddressService kakaoAddressService) {
        this.kakaoAddressService = kakaoAddressService;
    }

    @Override
    public PlaceResponse search(final Keyword keyword) {
        final Documents documents = kakaoAddressService.search(keyword.getQuery(), keyword.getSize(), keyword.getPage());
        final List<Document> docs = documents.getDocuments();

        return new PlaceResponse(getPlaceDocument(docs), getMetaDocument(documents.getMeta(), keyword));
    }

    private List<PlaceResponse.PlaceDocument> getPlaceDocument(List<Document> documents) {
        return documents.stream()
                .map(document -> new PlaceResponse.PlaceDocument(
                        document.getPlaceName(),
                        document.getPlaceUrl(),
                        document.getCategoryName(),
                        document.getAddressName(),
                        document.getRoadAddressName(),
                        document.getPhone(),
                        String.format(DAUM_MAP_LINK, document.getId())
                ))
                .collect(Collectors.toList());
    }

    private PlaceResponse.MetaDocument getMetaDocument(Meta meta, Keyword keyword) {
        return new PlaceResponse.MetaDocument(meta.isEnd(), meta.getPageableCount(), meta.getTotalCount(),
                keyword.getSize(), keyword.getPage());
    }
}
