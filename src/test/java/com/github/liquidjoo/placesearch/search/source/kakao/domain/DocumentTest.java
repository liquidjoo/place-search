package com.github.liquidjoo.placesearch.search.source.kakao.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class DocumentTest {

    private String json;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        json = "{\n" +
                "            \"address\": {\n" +
                "                \"address_name\": \"전북 익산시 부송동 100\",\n" +
                "                \"b_code\": \"4514013400\",\n" +
                "                \"h_code\": \"4514069000\",\n" +
                "                \"main_address_no\": \"100\",\n" +
                "                \"mountain_yn\": \"N\",\n" +
                "                \"region_1depth_name\": \"전북\",\n" +
                "                \"region_2depth_name\": \"익산시\",\n" +
                "                \"region_3depth_h_name\": \"삼성동\",\n" +
                "                \"region_3depth_name\": \"부송동\",\n" +
                "                \"sub_address_no\": \"\",\n" +
                "                \"x\": \"126.99597495347\",\n" +
                "                \"y\": \"35.9766482774579\"\n" +
                "            },\n" +
                "            \"address_name\": \"전북 익산시 부송동 100\",\n" +
                "            \"address_type\": \"REGION_ADDR\",\n" +
                "            \"road_address\": {\n" +
                "                \"address_name\": \"전북 익산시 망산길 11-17\",\n" +
                "                \"building_name\": \"\",\n" +
                "                \"main_building_no\": \"11\",\n" +
                "                \"region_1depth_name\": \"전북\",\n" +
                "                \"region_2depth_name\": \"익산시\",\n" +
                "                \"region_3depth_name\": \"부송동\",\n" +
                "                \"road_name\": \"망산길\",\n" +
                "                \"sub_building_no\": \"17\",\n" +
                "                \"underground_yn\": \"N\",\n" +
                "                \"x\": \"126.995995793098\",\n" +
                "                \"y\": \"35.97675110933\",\n" +
                "                \"zone_no\": \"54547\"\n" +
                "            },\n" +
                "            \"x\": \"126.99597495347\",\n" +
                "            \"y\": \"35.9766482774579\"\n" +
                "        }";

    }

    @Test
    @DisplayName("document mapping test")
    void mapping() throws JsonProcessingException {
        final Document document = objectMapper.readValue(json, Document.class);

        assertAll("document mapping",
                () -> assertThat(document.getAddressName()).isEqualTo("전북 익산시 부송동 100"),
                () -> assertThat(document.getAddressType()).isEqualTo("REGION_ADDR"),
                () -> assertThat(document.getX()).isEqualTo("126.99597495347"),
                () -> assertThat(document.getY()).isEqualTo("35.9766482774579")
                );
    }
}
