package com.company.MessageDelivery.exception;

public class NotFoundCommunicationException extends RuntimeException {

    // status should be here

    public NotFoundCommunicationException(String message) {
        super(message);
    }
}
