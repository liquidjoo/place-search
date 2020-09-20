package com.github.liquidjoo.placesearch.local.place.application;

import com.github.liquidjoo.placesearch.config.KeywordCache;
import com.github.liquidjoo.placesearch.local.place.domain.Keyword;
import com.github.liquidjoo.placesearch.local.place.domain.KeywordRepository;
import com.github.liquidjoo.placesearch.local.place.domain.PopularKeywords;
import com.github.liquidjoo.placesearch.local.place.domain.Searchable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = true)
public class PlaceService {

    private Searchable searchable;
    private KeywordRepository keywordRepository;

    public PlaceService(final Searchable searchable,
                        final KeywordRepository keywordRepository) {
        this.searchable = searchable;
        this.keywordRepository = keywordRepository;
    }

    public PlaceResponse search(Keyword keyword) {
        return searchable.search(keyword);
    }

    public PopularKeywordsResponse getKeywords() {
        final List<Keyword> keywords = keywordRepository.findAll();
        final List<PopularKeywordsResponse.KeywordsDocument> documents = keywords.stream()
                .map(keyword -> new PopularKeywordsResponse.KeywordsDocument(keyword.getQuery(), keyword.getCount()))
                .collect(Collectors.toList());

        return new PopularKeywordsResponse(documents);
    }

    @Transactional
    public void updateKeywordByCache() {
        final PopularKeywords popularKeywords = new PopularKeywords(keywordRepository.findAll());
        final List<String> queries = KeywordCache.getQueries();
        log.info("keyword cache count = {}", queries.size());
        if (!queries.isEmpty()) {
            queries.stream()
                    .map(Keyword::new)
                    .forEach(popularKeywords::addKeyword);

            keywordRepository.saveAll(popularKeywords.getKeywords());
            KeywordCache.invalidation();
        }
    }
}
