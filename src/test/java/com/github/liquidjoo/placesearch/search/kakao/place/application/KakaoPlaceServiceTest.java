package com.github.liquidjoo.placesearch.search.kakao.place.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.liquidjoo.placesearch.search.kakao.place.domain.ApiRequest;
import com.github.liquidjoo.placesearch.search.kakao.place.domain.Documents;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class KakaoPlaceServiceTest {

    @Mock
    private ApiRequest apiRequest;

    @InjectMocks
    private KakaoPlaceService kakaoPlaceService;

    private ObjectMapper objectMapper;
    private String json;

    private Documents documents;

    @Test
    @DisplayName("검색결과 객체매핑 테스트")
    void searchTest() throws JsonProcessingException {
        documents = objectMapper.readValue(json, Documents.class);
        given(apiRequest.request("카카오프렌즈", 15, 1))
                .willReturn(documents);

        final Documents actual = kakaoPlaceService.search("카카오프렌즈", 15, 1);

        assertThat(actual.getDocuments().size()).isEqualTo(documents.getDocuments().size());
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
