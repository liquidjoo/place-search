package com.github.liquidjoo.placesearch.search.source.kakao.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class AddressAbstractApiRequestTest {
    private AddressAbstractApiRequest addressAbstractApiRequest;

    @BeforeEach
    void setUp() {
        addressAbstractApiRequest = new AddressAbstractApiRequest(new RestTemplate());
        ReflectionTestUtils.setField(addressAbstractApiRequest, "appKey", "7fbc48e75f1528c602cd183aeca7e2b0", String.class);
    }

    @Test
    void request() {
        final Documents documents = addressAbstractApiRequest.request("전북 삼성동 100");
        assertAll("documents mapping",
                () -> assertThat(documents.getDocuments().size()).isEqualTo(3),
                () -> assertThat(documents.getMeta()).isNotNull()
        );
    }
}
