package com.company.MessageDelivery.exception;

import org.springframework.http.HttpStatus;

public class TransferFileException extends RuntimeException {

    private final int status;

    public TransferFileException(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

    public int getStatus() {
        return status;
    }
}
