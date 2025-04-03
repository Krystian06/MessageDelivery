package com.company.MessageDelivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(NotFoundCommunicationException.class)
    public ResponseEntity<ErrorMessage> notFoundCommunicationException(NotFoundCommunicationException notFoundCommunicationException) {
        ErrorMessage errorMessage = new ErrorMessage(notFoundCommunicationException.getMessage(), notFoundCommunicationException.getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatusCode.valueOf(errorMessage.getStatus()));
    }

    @ExceptionHandler(NotFoundCommunicationTypeException.class)
    public ResponseEntity<ErrorMessage> notFoundCommunicationTypeException(NotFoundCommunicationTypeException notFoundCommunicationTypeException) {
        ErrorMessage errorMessage = new ErrorMessage(notFoundCommunicationTypeException.getMessage(), notFoundCommunicationTypeException.getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatusCode.valueOf(errorMessage.getStatus()));
    }

    @ExceptionHandler(NotFoundDirectoryException.class)
    public ResponseEntity<ErrorMessage> notFoundDirectoryException(NotFoundDirectoryException notFoundDirectoryException) {
        ErrorMessage errorMessage = new ErrorMessage(notFoundDirectoryException.getMessage(), notFoundDirectoryException.getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatusCode.valueOf(errorMessage.getStatus()));
    }

    @ExceptionHandler(ParseJsonException.class)
    public ResponseEntity<ErrorMessage> parseJsonException(ParseJsonException parseJsonException) {
        ErrorMessage errorMessage = new ErrorMessage(parseJsonException.getMessage(), parseJsonException.getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatusCode.valueOf(errorMessage.getStatus()));
    }

    @ExceptionHandler(TransferFileException.class)
    public ResponseEntity<ErrorMessage> transferFileException(TransferFileException transferFileException) {
        ErrorMessage errorMessage = new ErrorMessage(transferFileException.getMessage(), transferFileException.getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatusCode.valueOf(errorMessage.getStatus()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> exception(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorMessage, HttpStatusCode.valueOf(errorMessage.getStatus()));
    }
}
