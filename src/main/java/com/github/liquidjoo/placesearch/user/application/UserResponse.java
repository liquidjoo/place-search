package com.github.liquidjoo.placesearch.user.application;

import lombok.ToString;

@ToString
public class UserResponse {

    private String userId;

    public UserResponse(final String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
