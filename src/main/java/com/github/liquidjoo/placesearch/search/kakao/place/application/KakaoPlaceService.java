package com.github.liquidjoo.placesearch.search.kakao.place.application;

import com.github.liquidjoo.placesearch.search.kakao.place.domain.ApiRequest;
import com.github.liquidjoo.placesearch.search.kakao.place.domain.Documents;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

@Service
public class KakaoPlaceService {

    private final ApiRequest<Documents> apiRequest;

    public KakaoPlaceService(final ApiRequest apiRequest) {
        this.apiRequest = apiRequest;
    }

    public Documents search(String query, int size, int page) throws RestClientException {
        return apiRequest.request(query, size, page);
    }
}
