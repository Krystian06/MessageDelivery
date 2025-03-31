package com.company.MessageDelivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(NotFoundCommunicationException.class)
    public ResponseEntity<ErrorMessage> notFoundCommunicationException(NotFoundCommunicationException notFoundCommunicationException) {
        ErrorMessage errorMessage = new ErrorMessage(notFoundCommunicationException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundCommunicationTypeException.class)
    public ResponseEntity<ErrorMessage> notFoundCommunicationTypeException(NotFoundCommunicationTypeException notFoundCommunicationTypeException) {
        ErrorMessage errorMessage = new ErrorMessage(notFoundCommunicationTypeException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundDirectoryException.class)
    public ResponseEntity<ErrorMessage> notFoundDirectoryException(NotFoundDirectoryException notFoundDirectoryException) {
        ErrorMessage errorMessage = new ErrorMessage(notFoundDirectoryException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ParseJsonException.class)
    public ResponseEntity<ErrorMessage> parseJsonException(ParseJsonException parseJsonException) {
        ErrorMessage errorMessage = new ErrorMessage(parseJsonException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TransferFileException.class)
    public ResponseEntity<ErrorMessage> transferFileException(TransferFileException transferFileException) {
        ErrorMessage errorMessage = new ErrorMessage(transferFileException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> exception(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
