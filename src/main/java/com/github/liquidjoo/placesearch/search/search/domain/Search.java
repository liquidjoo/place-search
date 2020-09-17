package com.github.liquidjoo.placesearch.search.search.domain;

import java.util.Objects;

public class Search {

    private final String query;

    public Search(final String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        final Search search = (Search) object;
        return Objects.equals(query, search.query);
    }

    @Override
    public int hashCode() {
        return Objects.hash(query);
    }
}
