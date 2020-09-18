package com.github.liquidjoo.placesearch.local.address.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KeywordTest {

    private Keyword keyword;

    @BeforeEach
    void setUp() {
        keyword = new Keyword("전북 삼성동 100");
    }

    @Test
    @DisplayName("객체 비교")
    void equalsToObject() {
        Keyword actual = keyword;
        Keyword expected = new Keyword("전북 삼성동 100");

        boolean same = actual.equals(expected);

        assertThat(same).isTrue();
    }

    @Test
    @DisplayName("쿼리 확인")
    void getQuery() {
        String actualQuery = keyword.getQuery();
        String expectedQuery = "전북 삼성동 100";

        boolean same = actualQuery.equals(expectedQuery);

        assertThat(same).isTrue();
    }

}
