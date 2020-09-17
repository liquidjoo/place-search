package com.github.liquidjoo.placesearch.search.search.domain;

@FunctionalInterface
public interface AddressSearchSource {

    Object search(String query);
}
