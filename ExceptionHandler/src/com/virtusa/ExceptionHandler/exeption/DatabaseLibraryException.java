package com.virtusa.ExceptionHandler.exeption;

public class DatabaseLibraryException extends RuntimeException{

    static final long serialVersionUID = -1;
    public  DatabaseLibraryException(String message,Throwable cause){
        super(message,cause);
    }
}
