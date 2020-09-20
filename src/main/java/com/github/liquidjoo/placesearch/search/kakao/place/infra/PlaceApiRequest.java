package com.github.liquidjoo.placesearch.search.kakao.place.infra;

import com.github.liquidjoo.placesearch.search.kakao.place.domain.ApiRequest;
import com.github.liquidjoo.placesearch.search.kakao.place.domain.Documents;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PlaceApiRequest implements ApiRequest<Documents> {

    private static final String URI = "/local/search/keyword.json?query={query}&size={size}&page={page}";

    @Value("${kakao.app-key}")
    private String appKey;

    @Value("${kakao.host.url}")
    private String host;

    @Value("${kakao.api.version}")
    private String apiVersion;

    private RestTemplate restTemplate;

    public PlaceApiRequest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Documents request(String query, int size, int page) {
        String url = getBaseUrl() + URI;
        final ResponseEntity<Documents> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                getEntity(appKey),
                Documents.class,
                query, size, page
        );
        return responseEntity.getBody();
    }

    private HttpEntity getEntity(String appKey) {
        return new HttpEntity(getHeaders(appKey));
    }

    private HttpHeaders getHeaders(String appKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", String.format("KakaoAK %s", appKey));
        return headers;
    }

    private String getBaseUrl() {
        return host + apiVersion;
    }
}
