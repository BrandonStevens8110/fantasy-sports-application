package com.fantasy.sports.exception;

public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message) {
        super(message + "is invalid.");
    }
}
