package com.github.liquidjoo.placesearch;

import com.github.liquidjoo.placesearch.local.place.domain.Keyword;
import com.github.liquidjoo.placesearch.local.place.domain.KeywordRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PopularKeywordsRunner implements ApplicationRunner {

    private KeywordRepository keywordRepository;

    public PopularKeywordsRunner(final KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        initKeywords();
    }

    private void initKeywords() {
        final List<Keyword> keywords = Arrays.asList(
                new Keyword("카카오", 142),
                new Keyword("양지병원", 32),
                new Keyword("신림동", 44),
                new Keyword("서울대입구", 53),
                new Keyword("칼하트", 64),
                new Keyword("치킨", 100),
                new Keyword("카카오프렌즈", 111),
                new Keyword("카카오뱅크", 164),
                new Keyword("편의점", 22),
                new Keyword("한솥", 88),
                new Keyword("백다방", 92),
                new Keyword("스타벅스", 99)
        );

        keywordRepository.saveAll(keywords);
    }
}
