package com.github.liquidjoo.placesearch.search.kakao.address.application;

import com.github.liquidjoo.placesearch.search.kakao.address.domain.ApiRequest;
import com.github.liquidjoo.placesearch.search.kakao.address.domain.Documents;
import org.springframework.stereotype.Service;

@Service
public class KakaoAddressService {

    private final ApiRequest<Documents> apiRequest;

    public KakaoAddressService(final ApiRequest apiRequest) {
        this.apiRequest = apiRequest;
    }

    public Documents search(String query) {
        return apiRequest.request(query);
    }
}
