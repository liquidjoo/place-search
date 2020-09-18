package com.github.liquidjoo.placesearch.local.address.domain;

import com.github.liquidjoo.placesearch.local.address.application.AddressResponse;

public interface Searchable {
    AddressResponse search(String query);
}
