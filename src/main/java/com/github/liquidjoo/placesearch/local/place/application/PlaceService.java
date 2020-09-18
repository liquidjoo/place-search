package com.github.liquidjoo.placesearch.local.place.application;

import com.github.liquidjoo.placesearch.local.place.domain.Keyword;
import com.github.liquidjoo.placesearch.local.place.domain.Searchable;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {

    private Searchable searchable;

    public PlaceService(final Searchable searchable) {
        this.searchable = searchable;
    }

    public PlaceResponse search(Keyword keyword) {
        return searchable.search(keyword);
    }
}
