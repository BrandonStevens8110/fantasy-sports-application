package com.fantasy.sports.Exception;

public class DuplicateDataException extends RuntimeException{
    public DuplicateDataException(String message) {
        super(message + " already exists");
    }
}
