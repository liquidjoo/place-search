package com.github.liquidjoo.placesearch.search.kakao.place.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
public class Meta {

    @JsonProperty(value = "same_name")
    private SameName sameName;

    @JsonProperty(value = "is_end")
    private boolean isEnd;

    @JsonProperty(value = "pageable_count")
    private int pageableCount;

    @JsonProperty(value = "total_count")
    private int totalCount;

    private static class SameName {

        @JsonProperty(value = "region")
        private List<String> region = new ArrayList<>();

        @JsonProperty(value = "keyword")
        private String keyword;

        @JsonProperty(value = "selected_region")
        private String selectedRegion;
    }
}
