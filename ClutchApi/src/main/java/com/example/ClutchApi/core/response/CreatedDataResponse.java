package com.example.ClutchApi.core.response;

public class CreatedDataResponse {
        private boolean success;
    private MessageType message;

    public CreatedDataResponse(boolean success, MessageType message) {
        this.success = success;
        this.message = message;
    }


     public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public MessageType getMessage() { return message; }
    public void setMessage(MessageType message) { this.message = message; }


}
