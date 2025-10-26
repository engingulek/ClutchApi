package com.example.ClutchApi.core.response;

public class CreatedDataResponse {
        private boolean success;
    private ErrorMessage message;

    public CreatedDataResponse(boolean success, ErrorMessage message) {
        this.success = success;
        this.message = message;
    }


     public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public ErrorMessage getMessage() { return message; }
    public void setMessage(ErrorMessage message) { this.message = message; }


}
