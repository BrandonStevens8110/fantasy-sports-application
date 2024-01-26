package com.fantasy.sports.exception;

public class DuplicateDataException extends RuntimeException{
    public DuplicateDataException(String message) {
        super(message + " already exists");
    }
}
