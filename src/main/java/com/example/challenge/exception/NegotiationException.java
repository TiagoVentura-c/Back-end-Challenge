package com.example.challenge.exception;

public class NegotiationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NegotiationException(String message) {
        super(message);
    }
}
