package com.github.liquidjoo.placesearch.user.application;

public class UserRequest {

    private String userId;

    private String password;

    UserRequest() {

    }

    public UserRequest(final String userId, final String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
