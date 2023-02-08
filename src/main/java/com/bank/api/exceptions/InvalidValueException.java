package com.bank.api.exceptions;

public class InvalidValueException extends RuntimeException {

    public InvalidValueException() {
        super();
    }

    public InvalidValueException(final String message) {
        super(message);
    }
}
