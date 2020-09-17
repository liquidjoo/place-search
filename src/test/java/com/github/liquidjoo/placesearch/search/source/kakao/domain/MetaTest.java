package com.github.liquidjoo.placesearch.search.source.kakao.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class MetaTest {

    private String json;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        json = "{\n" +
                "        \"is_end\": true,\n" +
                "        \"pageable_count\": 3,\n" +
                "        \"total_count\": 3\n" +
                "    }";

        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("meta object mapping")
    void mapping() throws JsonProcessingException {
        final Meta meta = objectMapper.readValue(json, Meta.class);
        assertAll("meta mapping",
                () -> assertThat(meta.isEnd()).isTrue(),
                () -> assertThat(meta.getPageableCount()).isEqualTo(3),
                () -> assertThat(meta.getTotalCount()).isEqualTo(3)
        );
    }
}
