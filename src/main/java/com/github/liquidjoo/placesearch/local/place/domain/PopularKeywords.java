package com.github.liquidjoo.placesearch.local.place.domain;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class PopularKeywords {

    private List<Keyword> keywords;

    PopularKeywords() {
        this.keywords = new ArrayList<>();
    }

    public void addKeyword(Keyword keyword) {
        if (this.keywords.contains(keyword)) {
            keyword.increaseCount();
            return;
        }
        this.keywords.add(keyword);
    }

    public void addKeywords(List<Keyword> keywords) {
        this.keywords.addAll(keywords);
    }

    public List<Keyword> getKeywords() {
        return this.keywords.stream()
                .sorted((keyword, targetKeyword) -> {
                    if (keyword.getCount() < targetKeyword.getCount()) {
                        return 1;
                    } else if (keyword.getCount() > targetKeyword.getCount()) {
                        return -1;
                    }
                    return 0;
                })
                .limit(10)
                .collect(Collectors.toList());
    }
}
