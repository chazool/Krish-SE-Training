package com.virtusa.ExceptionHandler.exeption;

public class InvalidIdExeption extends RuntimeException {

    static final long serialVersionUID = -1;

    public InvalidIdExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidIdExeption(String message) {
        super(message);
    }
}
