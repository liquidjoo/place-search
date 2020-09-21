package com.github.liquidjoo.placesearch.user.exception;

public class UserInfoNotFoundException extends IllegalArgumentException {

    private static final String MESSAGE = "not found user info";
    public UserInfoNotFoundException() {
        super(MESSAGE);
    }
}
