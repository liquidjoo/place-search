package com.github.liquidjoo.placesearch.search.source.kakao.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AddressAbstractApiRequest extends AbstractApiRequest<Documents> {

    private static final String URI = "/local/search/address.json?query={query}";
    private RestTemplate restTemplate;

    @Value("${kakao.app-key}")
    private String appKey;

    public AddressAbstractApiRequest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Documents request(String query) {
        String url = getBaseUrl() + URI;
        final ResponseEntity<Documents> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                getEntity(appKey),
                Documents.class,
                query
        );
        return responseEntity.getBody();
    }

    @Override
    public HttpEntity getEntity(String appKey) {
        return super.getEntity(appKey);
    }

    @Override
    public String getBaseUrl() {
        return super.getBaseUrl();
    }
}
