package com.github.liquidjoo.placesearch.local.search.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SearchTest {

    private Search search;

    @BeforeEach
    void setUp() {
        search = new Search("전북 삼성동 100");
    }

    @Test
    @DisplayName("객체 비교")
    void equalsToObject() {
        Search actualSearch = search;
        Search expectedSearch = new Search("전북 삼성동 100");

        boolean same = actualSearch.equals(expectedSearch);

        assertThat(same).isTrue();
    }

    @Test
    @DisplayName("쿼리 확인")
    void getQuery() {
        String actualQuery = search.getQuery();
        String expectedQuery = "전북 삼성동 100";

        boolean same = actualQuery.equals(expectedQuery);

        assertThat(same).isTrue();
    }
}
