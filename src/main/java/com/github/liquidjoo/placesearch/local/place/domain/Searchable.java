package com.github.liquidjoo.placesearch.local.place.domain;

import com.github.liquidjoo.placesearch.local.place.application.PlaceResponse;

public interface Searchable {
    PlaceResponse search(String query);
}
