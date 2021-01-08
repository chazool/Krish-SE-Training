package com.virtusa.projectservice.projectservice.exception;

public class CompulsoryFieldNullException extends RuntimeException {
    public CompulsoryFieldNullException(String message) {
        super(message);
    }
    public CompulsoryFieldNullException(String message, Throwable cause) {
        super(message, cause);
    }


}
