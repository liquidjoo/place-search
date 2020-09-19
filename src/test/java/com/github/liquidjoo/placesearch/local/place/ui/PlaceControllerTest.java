package com.github.liquidjoo.placesearch.local.place.ui;

import com.github.liquidjoo.placesearch.local.place.application.PlaceResponse;
import com.github.liquidjoo.placesearch.local.place.application.PlaceService;
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

    @BeforeEach
    void setUp() {
        final List<PlaceResponse.PlaceDocument> documents = Arrays.asList(
                new PlaceResponse.PlaceDocument("우리집", "http://localhost/home1", "집", "서울시", "서울로", "02-1111-1111", "http://link"),
                new PlaceResponse.PlaceDocument("우리집1", "http://localhost/home2", "집", "서울시", "서울로", "02-1111-1111", "http://link"),
                new PlaceResponse.PlaceDocument("우리집2", "http://localhost/home3", "집", "서울시", "서울로", "02-1111-1111", "http://link"),
                new PlaceResponse.PlaceDocument("우리집3", "http://localhost/home4", "집", "서울시", "서울로", "02-1111-1111", "http://link")

        );

        final PlaceResponse.MetaDocument metaDocument = new PlaceResponse.MetaDocument(true, 4, 4, 15, 1);

        placeResponse = new PlaceResponse(documents, metaDocument);
    }

    @Test
    @DisplayName("주소 검색 결과")
    void searchByAddress() throws Exception {
        given(placeService.search(any(Keyword.class)))
                .willReturn(placeResponse);

        final ResultActions resultActions = mockMvc.perform(get("/place/search")
                .contentType(MediaType.APPLICATION_JSON)
                .param("query", "my home")
        );

        resultActions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.addressDocuments").isArray())
                .andExpect(jsonPath("$.addressDocuments[0].addressName").isString());

    }

}
