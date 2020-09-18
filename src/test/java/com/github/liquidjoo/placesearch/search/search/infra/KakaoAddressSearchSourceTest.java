package com.github.liquidjoo.placesearch.search.search.infra;

import com.github.liquidjoo.placesearch.search.source.kakao.address.domain.Documents;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class KakaoAddressSearchSourceTest {

    @Test
    @DisplayName("kakao local search api test")
    void searchApiTest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "KakaoAK 7fbc48e75f1528c602cd183aeca7e2b0");

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://dapi.kakao.com/v2/local/search/address.json?query={query}";

        HttpEntity request = new HttpEntity(headers);
        final ResponseEntity<Map> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                Map.class,
                "전북 삼성동 100"
        );

        assertAll("local api response",
                () -> assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK),
                () -> assertThat(responseEntity.getBody().containsKey("meta")).isTrue(),
                () -> assertThat(responseEntity.getBody().containsKey("documents")).isTrue()
        );
    }

    @Test
    @DisplayName("api response object mapping")
    void objectMappingByApiResponse() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "KakaoAK 7fbc48e75f1528c602cd183aeca7e2b0");

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://dapi.kakao.com/v2/local/search/address.json?query={query}";

        HttpEntity request = new HttpEntity(headers);
        final ResponseEntity<Documents> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                Documents.class,
                "전북 삼성동 100"
        );

        final Documents documents = responseEntity.getBody();

        assertAll("local api response",
                () -> assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK),
                () -> assertThat(documents.getDocuments()).isNotNull(),
                () -> assertThat(documents.getMeta()).isNotNull()
        );
    }
}
