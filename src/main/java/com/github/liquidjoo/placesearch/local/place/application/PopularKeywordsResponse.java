package com.github.liquidjoo.placesearch.local.place.application;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class PopularKeywordsResponse {

    private List<KeywordsDocument> keywordsDocuments;

    public PopularKeywordsResponse(List<KeywordsDocument> keywordsDocuments) {
        this.keywordsDocuments = keywordsDocuments;
    }

    @ToString
    @Getter
    public static class KeywordsDocument {
        private String keyword;
        private int count;

        public KeywordsDocument(final String keyword, final int count) {
            this.keyword = keyword;
            this.count = count;
        }
    }
}
