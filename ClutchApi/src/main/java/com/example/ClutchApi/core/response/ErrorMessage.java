package com.example.ClutchApi.core.response;

public enum ErrorMessage {
    EXIST_EMAIL("Email already exists"),
    USER_CREATED("User successfully created"),
    LOGIN_SUCCESS("Login successful"),
    LOGIN_FAILED("Email or password incorrect");

    private final String text;

    ErrorMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
