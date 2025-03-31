package com.company.MessageDelivery.exception;

public class ErrorMessage {

    private String message;
    private int status;

    public ErrorMessage(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
