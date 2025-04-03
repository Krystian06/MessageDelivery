package com.company.MessageDelivery.exception;

import org.springframework.http.HttpStatus;

public class NotFoundCommunicationTypeException extends RuntimeException {

    private final int status;

    public NotFoundCommunicationTypeException(String message) {
        super(message);
        this.status = HttpStatus.NOT_FOUND.value();
    }

    public int getStatus() {
        return status;
    }
}
