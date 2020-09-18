package com.github.liquidjoo.placesearch.search.source.kakao.address.domain;

import com.github.liquidjoo.placesearch.search.source.kakao.address.infra.AddressApiRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class AddressApiRequestTest {
    private AddressApiRequest addressApiRequest;

    @BeforeEach
    void setUp() {
        addressApiRequest = new AddressApiRequest(new RestTemplate());
        ReflectionTestUtils.setField(addressApiRequest, "appKey", "7fbc48e75f1528c602cd183aeca7e2b0", String.class);
        ReflectionTestUtils.setField(addressApiRequest, "host", "https://dapi.kakao.com", String.class);
        ReflectionTestUtils.setField(addressApiRequest, "apiVersion", "/v2", String.class);
    }

    @Test
    void request() {
        final Documents documents = addressApiRequest.request("전북 삼성동 100");
        assertAll("documents mapping",
                () -> assertThat(documents.getDocuments().size()).isEqualTo(3),
                () -> assertThat(documents.getMeta()).isNotNull()
        );
    }
}
