package com.fabricefo.hexagonal.domain.exception;

public class TodoNotFoundException extends RuntimeException {
    
    public TodoNotFoundException(String msg) {
        super(msg);
    }
}
