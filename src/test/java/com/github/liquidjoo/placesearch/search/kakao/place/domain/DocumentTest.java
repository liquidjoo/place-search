package com.github.liquidjoo.placesearch.search.kakao.place.domain;

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
                "      \"place_name\": \"카카오프렌즈 코엑스점\",\n" +
                "      \"distance\": \"418\",\n" +
                "      \"place_url\": \"http://place.map.kakao.com/26338954\",\n" +
                "      \"category_name\": \"가정,생활 > 문구,사무용품 > 디자인문구 > 카카오프렌즈\",\n" +
                "      \"address_name\": \"서울 강남구 삼성동 159\",\n" +
                "      \"road_address_name\": \"서울 강남구 영동대로 513\",\n" +
                "      \"id\": \"26338954\",\n" +
                "      \"phone\": \"02-6002-1880\",\n" +
                "      \"category_group_code\": \"\",\n" +
                "      \"category_group_name\": \"\",\n" +
                "      \"x\": \"127.05902969025047\",\n" +
                "      \"y\": \"37.51207412593136\"\n" +
                "}";

    }

    @Test
    @DisplayName("document mapping test")
    void mapping() throws JsonProcessingException {
        final Document document = objectMapper.readValue(json, Document.class);

        assertAll("document mapping",
                () -> assertThat(document.getAddressName()).isEqualTo("서울 강남구 삼성동 159"),
                () -> assertThat(document.getX()).isEqualTo("127.05902969025047"),
                () -> assertThat(document.getY()).isEqualTo("37.51207412593136")
        );
    }
}
