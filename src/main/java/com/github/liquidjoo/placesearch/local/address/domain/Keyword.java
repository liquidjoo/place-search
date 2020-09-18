package com.github.liquidjoo.placesearch.local.address.domain;

import java.util.Objects;

public class Keyword {
    private String query;

    public Keyword(final String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        final Keyword keyword = (Keyword) object;
        return Objects.equals(query, keyword.query);
    }

    @Override
    public int hashCode() {
        return Objects.hash(query);
    }
}
