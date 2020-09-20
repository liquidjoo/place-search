package com.github.liquidjoo.placesearch.local.place.application;

import com.github.liquidjoo.placesearch.local.place.domain.Keyword;
import com.github.liquidjoo.placesearch.local.place.domain.KeywordRepository;
import com.github.liquidjoo.placesearch.local.place.domain.Searchable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PlaceServiceTest {

    @Mock
    private Searchable searchable;

    @Mock
    private KeywordRepository keywordRepository;

    @InjectMocks
    private PlaceService placeService;

    private PlaceResponse placeResponse;
    private List<Keyword> keywords;

    @BeforeEach
    void setUp() {
        placeResponse = initPlace();
        keywords = initKeywords();
    }

    @Test
    void search() {
        given(searchable.search(new Keyword("우리집")))
                .willReturn(placeResponse);

        final PlaceResponse response = placeService.search(new Keyword("우리집"));

        assertThat(response.getPlaceDocuments().size())
                .isEqualTo(placeResponse.getPlaceDocuments().size());
    }

    @Test
    void getPopularKeyword() {
        given(keywordRepository.findAll())
                .willReturn(initKeywords());

        final PopularKeywordsResponse actual = placeService.getKeywords();
        final PopularKeywordsResponse.KeywordsDocument document = actual.getKeywordsDocuments().get(0);

        assertThat(document.getKeyword()).isEqualTo("카카오");
    }

    private PlaceResponse initPlace() {
        final List<PlaceResponse.PlaceDocument> documents = Arrays.asList(
                new PlaceResponse.PlaceDocument("우리집", "http://localhost/home1", "집", "서울시", "서울로", "02-1111-1111", "http://link"),
                new PlaceResponse.PlaceDocument("우리집1", "http://localhost/home2", "집", "서울시", "서울로", "02-1111-1111", "http://link"),
                new PlaceResponse.PlaceDocument("우리집2", "http://localhost/home3", "집", "서울시", "서울로", "02-1111-1111", "http://link"),
                new PlaceResponse.PlaceDocument("우리집3", "http://localhost/home4", "집", "서울시", "서울로", "02-1111-1111", "http://link")

        );
        final PlaceResponse.MetaDocument metaDocument = new PlaceResponse.MetaDocument(true, 4, 4, 15, 1);
        return new PlaceResponse(documents, metaDocument);
    }

    private List<Keyword> initKeywords() {
        keywords = Arrays.asList(
                new Keyword("신림", 4),
                new Keyword("서울대", 2),
                new Keyword("홍대", 44),
                new Keyword("강남", 31),
                new Keyword("영등포", 1),
                new Keyword("방배", 3),
                new Keyword("사당", 5),
                new Keyword("교대", 23),
                new Keyword("서초", 2),
                new Keyword("카카오", 65)
        );
        return keywords.stream()
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
