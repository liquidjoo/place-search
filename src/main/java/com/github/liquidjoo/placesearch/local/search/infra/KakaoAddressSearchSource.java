package com.github.liquidjoo.placesearch.local.search.infra;

import com.github.liquidjoo.placesearch.local.search.domain.AddressSearchSource;
import org.springframework.stereotype.Component;

@Component
public class KakaoAddressSearchSource implements AddressSearchSource {

    @Override
    public Object search(final String query) {
        return null;
    }
}
