package com.github.liquidjoo.placesearch.config;

import java.util.ArrayList;
import java.util.List;

public class KeywordCache {

    private static final List<String> queries = new ArrayList<>();

    public static void add(String query) {
        queries.add(query);
    }

    public static List<String> getQueries() {
        return new ArrayList<>(queries);
    }

    public static void invalidation() {
        queries.clear();
    }
}
