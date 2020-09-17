package com.github.liquidjoo.placesearch.search.source.kakao.domain;

public interface ApiRequest<T> {

    T request(String query);
}
