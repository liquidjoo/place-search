package com.github.liquidjoo.placesearch.search.kakao.place.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DocumentsTest {

    private String json;
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("documents mapping test")
    void mapping() throws JsonProcessingException {
        final Documents documents = objectMapper.readValue(json, Documents.class);

        assertAll("documents mapping",
                () -> assertThat(documents.getDocuments()).isNotNull(),
                () -> assertThat(documents.getMeta()).isNotNull()
                );
    }

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        json = "{\n" +
                "  \"meta\": {\n" +
                "    \"same_name\": {\n" +
                "      \"region\": [],\n" +
                "      \"keyword\": \"카카오프렌즈\",\n" +
                "      \"selected_region\": \"\"\n" +
                "    },\n" +
                "    \"pageable_count\": 14,\n" +
                "    \"total_count\": 14,\n" +
                "    \"is_end\": true\n" +
                "  },\n" +
                "  \"documents\": [\n" +
                "    {\n" +
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
                "    }\n" +
                "  ]\n" +
                "}";
    }
}
