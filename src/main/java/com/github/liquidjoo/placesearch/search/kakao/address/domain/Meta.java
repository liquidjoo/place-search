package com.github.liquidjoo.placesearch.search.kakao.address.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Meta {
    @JsonProperty(value = "is_end")
    private boolean isEnd;

    @JsonProperty(value = "pageable_count")
    private int pageableCount;

    @JsonProperty(value = "total_count")
    private int totalCount;
}
