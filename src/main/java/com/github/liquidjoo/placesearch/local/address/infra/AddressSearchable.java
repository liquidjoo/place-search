package com.github.liquidjoo.placesearch.local.address.infra;

import com.github.liquidjoo.placesearch.local.address.application.AddressResponse;
import com.github.liquidjoo.placesearch.local.address.domain.Searchable;
import com.github.liquidjoo.placesearch.search.kakao.address.application.KakaoAddressService;
import com.github.liquidjoo.placesearch.search.kakao.address.domain.Document;
import com.github.liquidjoo.placesearch.search.kakao.address.domain.Documents;
import com.github.liquidjoo.placesearch.search.kakao.address.domain.Meta;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressSearchable implements Searchable {

    private final KakaoAddressService kakaoAddressService;

    public AddressSearchable(final KakaoAddressService kakaoAddressService) {
        this.kakaoAddressService = kakaoAddressService;
    }

    @Override
    public AddressResponse search(final String query) {
        final Documents documents = kakaoAddressService.search(query);
        final List<Document> docs = documents.getDocuments();

        return new AddressResponse(getAddressDocument(docs), getMetaDocument(documents.getMeta()));
    }

    private List<AddressResponse.AddressDocument> getAddressDocument(List<Document> documents) {
        return documents.stream()
                .map(document -> new AddressResponse.AddressDocument(
                        document.getAddressName(),
                        document.getX(),
                        document.getY()))
                .collect(Collectors.toList());
    }

    private AddressResponse.MetaDocument getMetaDocument(Meta meta) {
        return new AddressResponse.MetaDocument(meta.isEnd(), meta.getPageableCount(), meta.getTotalCount());
    }
}
