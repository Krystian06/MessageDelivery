package com.company.MessageDelivery.exception;

import org.springframework.http.HttpStatus;

public class NotFoundDirectoryException extends RuntimeException {

    private final int status;

    public NotFoundDirectoryException(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

    public int getStatus() {
        return status;
    }
}
