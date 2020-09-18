package com.github.liquidjoo.placesearch.search.kakao.place.domain;

public interface ApiRequest<T> {

    T request(String query, int size, int page);
}
