package com.github.liquidjoo.placesearch.local.place.ui;

import com.github.liquidjoo.placesearch.local.place.application.PlaceResponse;
import com.github.liquidjoo.placesearch.local.place.application.PlaceService;
import com.github.liquidjoo.placesearch.local.place.application.PopularKeywordsResponse;
import com.github.liquidjoo.placesearch.local.place.domain.Keyword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlaceController.class)
@Import(HttpEncodingAutoConfiguration.class)
class PlaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlaceService placeService;

    private PlaceResponse placeResponse;
    private List<Keyword> keywords;

    @BeforeEach
    void setUp() {
        placeResponse = initPlace();
        keywords = initKeywords();
    }

    @Test
    @DisplayName("장소 검색 결과")
    void searchByPlace() throws Exception {
        given(placeService.search(any(Keyword.class)))
                .willReturn(placeResponse);

        final ResultActions resultActions = mockMvc.perform(get("/place/search")
                .contentType(MediaType.APPLICATION_JSON)
                .queryParam("query", "my home")
        );

        resultActions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.placeDocuments").isArray())
                .andExpect(jsonPath("$.placeDocuments[0].addressName").isString());

    }

    @Test
    @DisplayName("인기 검색어 결과 api")
    void popularKeyword() throws Exception {
        given(placeService.getKeywords())
                .willReturn(new PopularKeywordsResponse(initDocuments()));

        final ResultActions resultActions = mockMvc.perform(get("/place/popular/keywords"));
        resultActions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.keywordsDocuments").isArray())
                .andExpect(jsonPath("$.keywordsDocuments[0].keyword").isString());

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

    private List<PopularKeywordsResponse.KeywordsDocument> initDocuments() {
        return initKeywords().stream()
                .map(keyword -> new PopularKeywordsResponse.KeywordsDocument(keyword.getQuery(), keyword.getCount()))
                .collect(Collectors.toList());
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
