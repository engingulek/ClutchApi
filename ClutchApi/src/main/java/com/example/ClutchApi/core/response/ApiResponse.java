package com.example.ClutchApi.core.response;

public class ApiResponse<T> {
    private boolean success;
    private ErrorMessage message;
    private T data; // data null olabilir

    public ApiResponse(boolean success, ErrorMessage message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    // getter ve setter
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public ErrorMessage getMessage() { return message; }
    public void setMessage(ErrorMessage message) { this.message = message; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}
