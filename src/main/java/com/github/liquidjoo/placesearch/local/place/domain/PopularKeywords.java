package com.github.liquidjoo.placesearch.local.place.domain;

import java.util.List;
import java.util.stream.Collectors;

public class PopularKeywords {

    private List<Keyword> keywords;

    public PopularKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public void addKeyword(Keyword keyword) {
        if (this.keywords.contains(keyword)) {
            final Keyword foundedKeyword = this.keywords.stream()
                    .filter(key -> key.equals(keyword))
                    .findAny()
                    .get();
            foundedKeyword.increaseCount();
            return;
        }
        this.keywords.add(keyword);
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
