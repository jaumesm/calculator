package com.camaiot.calculator.exception;

/* TODO: Catch this at ExceptionHandler */
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }

}
