package com.github.liquidjoo.placesearch.search.kakao.place.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Document {

    @JsonProperty(value = "place_name")
    private String placeName;

    @JsonProperty(value = "distance")
    private String distance;

    @JsonProperty(value = "place_url")
    private String placeUrl;

    @JsonProperty(value = "category_name")
    private String categoryName;

    @JsonProperty(value = "address_name")
    private String addressName;

    @JsonProperty(value = "road_address_name")
    private String roadAddressName;

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "phone")
    private String phone;

    @JsonProperty(value = "category_group_code")
    private String categoryGroupCode;

    @JsonProperty(value = "category_group_name")
    private String categoryGroupName;

    @JsonProperty(value = "x")
    private String x;

    @JsonProperty(value = "y")
    private String y;
}



