package com.andrei.rest.exceptions;

public class UserCreateException extends RuntimeException{

    public UserCreateException(String message) {
        super(message);
    }
}
