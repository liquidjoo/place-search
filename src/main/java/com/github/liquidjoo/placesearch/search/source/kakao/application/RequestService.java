package com.github.liquidjoo.placesearch.search.source.kakao.application;

import com.github.liquidjoo.placesearch.search.source.kakao.address.domain.ApiRequest;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    private ApiRequest apiRequest;

    public RequestService(final ApiRequest apiRequest) {
        this.apiRequest = apiRequest;
    }
}
