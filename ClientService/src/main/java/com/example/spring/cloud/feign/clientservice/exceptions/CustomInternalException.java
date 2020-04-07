package com.example.spring.cloud.feign.clientservice.exceptions;

public class CustomInternalException extends RuntimeException {
    public CustomInternalException() {
        super();
    }

    public CustomInternalException(String message) {
        super(message);
    }

    public CustomInternalException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return "(500) Custom Internal error: " + getMessage();
    }
}
