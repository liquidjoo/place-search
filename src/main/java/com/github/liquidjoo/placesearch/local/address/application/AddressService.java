package com.github.liquidjoo.placesearch.local.address.application;

import com.github.liquidjoo.placesearch.local.address.domain.Keyword;
import com.github.liquidjoo.placesearch.local.address.domain.Searchable;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private Searchable searchable;

    public AddressService(final Searchable searchable) {
        this.searchable = searchable;
    }

    public AddressResponse search(Keyword keyword) {
        return searchable.search(keyword.getQuery());
    }
}
