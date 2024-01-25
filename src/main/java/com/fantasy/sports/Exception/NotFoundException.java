package com.fantasy.sports.Exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message + "not found.");
    }
}
