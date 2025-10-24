package com.example.ClutchApi.core.response;

public enum ErrorMessage {
    EXIST_ID("User already exists"),
    USER_CREATED("User successfully created"),
    SUCCESS_FETCH("Data fetched successfully");

    private final String text;

    ErrorMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
