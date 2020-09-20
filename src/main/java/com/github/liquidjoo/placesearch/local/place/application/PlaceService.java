package com.github.liquidjoo.placesearch.local.place.application;

import com.github.liquidjoo.placesearch.local.place.domain.Keyword;
import com.github.liquidjoo.placesearch.local.place.domain.PopularKeywords;
import com.github.liquidjoo.placesearch.local.place.domain.Searchable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceService {

    private Searchable searchable;
    private PopularKeywords popularKeywords;

    public PlaceService(final Searchable searchable, final PopularKeywords popularKeywords) {
        this.searchable = searchable;
        this.popularKeywords = popularKeywords;
    }

    public PlaceResponse search(Keyword keyword) {
        return searchable.search(keyword);
    }

    public PopularKeywordsResponse getKeywords() {
        final List<PopularKeywordsResponse.KeywordsDocument> documents = popularKeywords.getKeywords().stream()
                .map(keyword -> new PopularKeywordsResponse.KeywordsDocument(keyword.getQuery(), keyword.getCount()))
                .collect(Collectors.toList());

        return new PopularKeywordsResponse(documents);
    }
}
