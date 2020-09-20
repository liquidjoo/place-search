package com.github.liquidjoo.placesearch.local.place.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class PopularKeywordsTest {

    private PopularKeywords popularKeywords;

    @BeforeEach
    void setUp() {
        popularKeywords = new PopularKeywords(new ArrayList<>());
    }

    @Test
    @DisplayName("키워드 카운트")
    void increaseCountBySameObject() {

        final Keyword keyword = new Keyword("카카오");
        popularKeywords.addKeyword(keyword);
        popularKeywords.addKeyword(keyword);

        assertThat(keyword.getCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("순위 비교")
    void compareToListOrder() {
        final Keyword kakao = new Keyword("카카오");
        final Keyword hi = new Keyword("안녕");

        popularKeywords.addKeyword(kakao);
        popularKeywords.addKeyword(hi);

        popularKeywords.addKeyword(kakao);
        popularKeywords.addKeyword(hi);
        popularKeywords.addKeyword(hi);

        Keyword actualHi = popularKeywords.getKeywords().get(0);
        Keyword expected = new Keyword("안녕");

        boolean same = actualHi.equals(expected);

        assertThat(same).isTrue();
    }
}
