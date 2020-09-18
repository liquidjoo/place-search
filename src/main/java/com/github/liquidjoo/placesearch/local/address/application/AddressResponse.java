package com.github.liquidjoo.placesearch.local.address.application;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class AddressResponse {

    private final List<AddressDocument> addressDocuments;
    private final MetaDocument metaDocument;

    public AddressResponse(final List<AddressDocument> addressDocuments, final MetaDocument metaDocument) {
        this.addressDocuments = addressDocuments;
        this.metaDocument = metaDocument;
    }

    public List<AddressDocument> getAddressDocuments() {
        return new ArrayList<>(addressDocuments);
    }

    public MetaDocument getMetaDocument() {
        return metaDocument;
    }

    @Getter
    @ToString
    public static class AddressDocument {
        private String addressName;
        private String x;
        private String y;

        public AddressDocument(final String addressName, final String x, final String y) {
            this.addressName = addressName;
            this.x = x;
            this.y = y;
        }
    }

    @Getter
    @ToString
    public static class MetaDocument {
        private boolean isEnd;
        private int pageableCount;
        private int totalCount;

        public MetaDocument(final boolean isEnd, final int pageableCount, final int totalCount) {
            this.isEnd = isEnd;
            this.pageableCount = pageableCount;
            this.totalCount = totalCount;
        }
    }
}
