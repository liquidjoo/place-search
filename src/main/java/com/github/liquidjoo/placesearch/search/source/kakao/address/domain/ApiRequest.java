package com.github.liquidjoo.placesearch.search.source.kakao.address.domain;

public interface ApiRequest<T> {

    T request(String query);
}
