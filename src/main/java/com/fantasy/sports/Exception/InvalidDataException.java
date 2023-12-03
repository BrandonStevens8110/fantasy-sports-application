package com.fantasy.sports.Exception;

public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message) {
        super(message + "is invalid.");
    }
}
