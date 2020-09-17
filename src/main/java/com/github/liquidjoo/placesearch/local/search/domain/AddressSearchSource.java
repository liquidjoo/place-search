package com.github.liquidjoo.placesearch.local.search.domain;

@FunctionalInterface
public interface AddressSearchSource {

    Object search(String query);
}
