package com.github.liquidjoo.placesearch.user.application;

public class UserResponse {

    private String userId;

    public UserResponse(final String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + "]";
    }
}
