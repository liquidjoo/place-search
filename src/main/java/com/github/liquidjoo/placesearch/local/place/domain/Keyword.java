package com.github.liquidjoo.placesearch.local.place.domain;

import org.apache.logging.log4j.util.Strings;

import java.util.Objects;

public class Keyword {
    private String query;

    public Keyword(final String query) {
        validate(query);
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    private void validate(String query) {
        if (Strings.isBlank(query)) {
            throw new IllegalArgumentException("검색어를 입력해주세요");
        }
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
