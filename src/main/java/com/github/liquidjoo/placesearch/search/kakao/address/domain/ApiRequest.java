package com.github.liquidjoo.placesearch.search.kakao.address.domain;

public interface ApiRequest<T> {

    T request(String query);
}
