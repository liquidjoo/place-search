package com.github.liquidjoo.placesearch.search.source.kakao.address.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Documents {
    @JsonProperty(value = "documents")
    private List<Document> documents;

    @JsonProperty(value = "meta")
    private Meta meta;

    public List<Document> getDocuments() {
        return new ArrayList<>(documents);
    }

    public Meta getMeta() {
        return meta;
    }
}
