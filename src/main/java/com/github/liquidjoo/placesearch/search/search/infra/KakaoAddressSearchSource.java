package com.github.liquidjoo.placesearch.search.search.infra;

import com.github.liquidjoo.placesearch.search.search.domain.AddressSearchSource;
import org.springframework.stereotype.Component;

@Component
public class KakaoAddressSearchSource implements AddressSearchSource {
    @Override
    public Object search(final String query) {
        return null;
    }
}
