package com.github.liquidjoo.placesearch.local.place.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class KeywordTest {

    private Keyword keyword;

    @BeforeEach
    void setUp() {
        keyword = new Keyword("카카오프렌즈");
    }

    @Test
    @DisplayName("객체 비교")
    void equalsToObject() {
        Keyword actual = keyword;
        Keyword expected = new Keyword("카카오프렌즈");

        boolean same = actual.equals(expected);

        assertThat(same).isTrue();
    }

    @Test
    @DisplayName("쿼리 확인")
    void getQuery() {
        String actualQuery = keyword.getQuery();
        String expectedQuery = "카카오프렌즈";

        boolean same = actualQuery.equals(expectedQuery);

        assertThat(same).isTrue();
    }

    @Test
    @DisplayName("빈 값 유효성 검사")
    void validateByEmptyQuery() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Keyword(""));
    }
}
