package com.company.MessageDelivery.exception;

import org.springframework.http.HttpStatus;

public class NotFoundCommunicationException extends RuntimeException {

    private final int status;

    public NotFoundCommunicationException(String message) {
        super(message);
        this.status = HttpStatus.NOT_FOUND.value();
    }

    public int getStatus() {
        return status;
    }
}
