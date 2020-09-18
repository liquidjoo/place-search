package com.github.liquidjoo.placesearch.local.place.infra;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.liquidjoo.placesearch.local.place.application.PlaceResponse;
import com.github.liquidjoo.placesearch.local.place.domain.Keyword;
import com.github.liquidjoo.placesearch.search.kakao.place.application.KakaoAddressService;
import com.github.liquidjoo.placesearch.search.kakao.place.domain.Documents;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PlaceSearchableTest {

    @Mock
    private KakaoAddressService kakaoAddressService;

    @InjectMocks
    private PlaceSearchable placeSearchable;

    private ObjectMapper objectMapper;
    private String json;

    private Documents documents;

    @Test
    @DisplayName("mapping response")
    void mappingBySearchResponse() throws JsonProcessingException {
        documents = objectMapper.readValue(json, Documents.class);

        given(kakaoAddressService.search("카카오프렌즈", 15, 1))
                .willReturn(documents);

        final PlaceResponse response = placeSearchable.search(new Keyword("카카오프렌즈"));

        assertAll("response",
                () -> assertThat(response.getPlaceDocuments().size()).isEqualTo(documents.getDocuments().size()),
                () -> assertThat(response.getMetaDocument()).isNotNull(),
                () -> assertThat(response.getMetaDocument().getTotalCount()).isEqualTo(documents.getMeta().getTotalCount())
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
