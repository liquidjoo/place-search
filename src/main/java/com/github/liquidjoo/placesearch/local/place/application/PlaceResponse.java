package com.github.liquidjoo.placesearch.local.place.application;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class PlaceResponse {

    private final List<PlaceDocument> addressDocuments;
    private final MetaDocument metaDocument;

    public PlaceResponse(final List<PlaceDocument> addressDocuments, final MetaDocument metaDocument) {
        this.addressDocuments = addressDocuments;
        this.metaDocument = metaDocument;
    }

    public List<PlaceDocument> getAddressDocuments() {
        return new ArrayList<>(addressDocuments);
    }

    public MetaDocument getMetaDocument() {
        return metaDocument;
    }

    @Getter
    @ToString
    public static class PlaceDocument {
        private String placeName;
        private String placeUrl;
        private String categoryName;
        private String addressName;
        private String roadAddressName;
        private String phone;
        private String linkUrl;

        public PlaceDocument(final String placeName, final String placeUrl, final String categoryName, final String addressName, final String roadAddressName, final String phone, final String linkUrl) {
            this.placeName = placeName;
            this.placeUrl = placeUrl;
            this.categoryName = categoryName;
            this.addressName = addressName;
            this.roadAddressName = roadAddressName;
            this.phone = phone;
            this.linkUrl = linkUrl;
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
