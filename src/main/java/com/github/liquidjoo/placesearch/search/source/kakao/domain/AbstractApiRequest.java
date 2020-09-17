package com.github.liquidjoo.placesearch.search.source.kakao.domain;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public abstract class AbstractApiRequest<T> implements ApiRequest<T> {

    private static final String HOST = "https://dapi.kakao.com";
    private static final String API_VERSION = "/v2";

    public HttpEntity getEntity(String appKey) {
        return new HttpEntity(getHeaders(appKey));
    }

    @Override
    public T request(String query) {
        return null;
    }

    private HttpHeaders getHeaders(String appKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", String.format("KakaoAK %s", appKey));
        return headers;
    }

    public String getBaseUrl() {
        return HOST + API_VERSION;
    }

}
