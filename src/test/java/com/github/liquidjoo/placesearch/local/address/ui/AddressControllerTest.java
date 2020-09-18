package com.github.liquidjoo.placesearch.local.address.ui;

import com.github.liquidjoo.placesearch.local.address.application.AddressResponse;
import com.github.liquidjoo.placesearch.local.address.application.AddressService;
import com.github.liquidjoo.placesearch.local.address.domain.Keyword;
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

@WebMvcTest(AddressController.class)
@Import(HttpEncodingAutoConfiguration.class)
class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressService addressService;

    private AddressResponse addressResponse;

    @BeforeEach
    void setUp() {
        final List<AddressResponse.AddressDocument> documents = Arrays.asList(
                new AddressResponse.AddressDocument("my home", "123.145", "556.745"),
                new AddressResponse.AddressDocument("my home1", "123.53245", "556.678"),
                new AddressResponse.AddressDocument("my home2", "123.2345", "556.44564"),
                new AddressResponse.AddressDocument("my home3", "123.234", "556.23424")
        );

        final AddressResponse.MetaDocument metaDocument = new AddressResponse.MetaDocument(true, 4, 4);

        addressResponse = new AddressResponse(documents, metaDocument);
    }

    @Test
    @DisplayName("주소 검색 결과")
    void searchByAddress() throws Exception {
        given(addressService.search(any(Keyword.class)))
                .willReturn(addressResponse);

        final ResultActions resultActions = mockMvc.perform(get("/address/search")
                .contentType(MediaType.APPLICATION_JSON)
                .param("query", "my home")
        );

        resultActions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.addressDocuments").isArray())
                .andExpect(jsonPath("$.addressDocuments[0].addressName").isString())
                .andExpect(jsonPath("$.addressDocuments[0].x").isString())
                .andExpect(jsonPath("$.addressDocuments[0].y").isString())

                .andExpect(jsonPath("$.metaDocument").isMap())
                .andExpect(jsonPath("$.metaDocument.pageableCount").isNumber())
                .andExpect(jsonPath("$.metaDocument.totalCount").isNumber())
                .andExpect(jsonPath("$.metaDocument.end").isBoolean());

    }
}
