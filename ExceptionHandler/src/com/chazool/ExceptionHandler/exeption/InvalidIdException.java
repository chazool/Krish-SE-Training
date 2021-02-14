package com.chazool.ExceptionHandler.exeption;

public class InvalidIdException extends RuntimeException {



    public InvalidIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidIdException(String message) {
        super(message);
    }
}
