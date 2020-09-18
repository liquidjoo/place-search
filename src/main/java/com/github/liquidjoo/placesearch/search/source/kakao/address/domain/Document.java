package com.github.liquidjoo.placesearch.search.source.kakao.address.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Document {

    @JsonProperty(value = "address")
    private Address address;

    @JsonProperty(value = "address_name")
    private String addressName;

    @JsonProperty(value = "address_type")
    private String addressType;

    @JsonProperty(value = "road_address")
    private RoadAddress roadAddress;

    @JsonProperty(value = "x")
    private String x;

    @JsonProperty(value = "y")
    private String y;

    @ToString
    private static class Address {
        @JsonProperty(value = "address_name")
        private String addressName;

        @JsonProperty(value = "b_code")
        private String bCode;

        @JsonProperty(value = "h_code")
        private String hCode;

        @JsonProperty(value = "main_address_no")
        private String mainAddressNo;

        @JsonProperty(value = "mountain_yn")
        private String mountainYN;

        @JsonProperty(value = "region_1depth_name")
        private String region1DepthName;

        @JsonProperty(value = "region_2depth_name")
        private String region2DepthName;

        @JsonProperty(value = "region_3depth_h_name")
        private String region3DepthHName;

        @JsonProperty(value = "region_3depth_name")
        private String region3DepthName;

        @JsonProperty(value = "sub_address_no")
        private String subAddressNo;

        @JsonProperty(value = "x")
        private String x;

        @JsonProperty(value = "y")
        private String y;
    }

    @ToString
    private static class RoadAddress {
        @JsonProperty(value = "address_name")
        private String addressName;

        @JsonProperty(value = "building_name")
        private String buildingName;

        @JsonProperty(value = "main_building_no")
        private String mainBuildingNo;

        @JsonProperty(value = "region_1depth_name")
        private String region1DepthName;

        @JsonProperty(value = "region_2depth_name")
        private String region2DepthName;

        @JsonProperty(value = "region_3depth_name")
        private String region3DepthName;

        @JsonProperty(value = "road_name")
        private String roadName;

        @JsonProperty(value = "sub_building_no")
        private String subBuilingNo;

        @JsonProperty(value = "underground_yn")
        private String underGroundYn;

        @JsonProperty(value = "x")
        private String x;

        @JsonProperty(value = "y")
        private String y;

        @JsonProperty(value = "zone_no")
        private String zoneNo;
    }
}



