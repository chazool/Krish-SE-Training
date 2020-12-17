package com.virtusa.ExceptionHandler.exeption;

public class SqlOppressionException extends RuntimeException{

    public SqlOppressionException(String message, Throwable cause){
        super(message,cause);
    }
}
