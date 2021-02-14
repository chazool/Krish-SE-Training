package com.chazool.ExceptionHandler.exeption;

public class DatabaseLibraryException extends RuntimeException{


    public  DatabaseLibraryException(String message,Throwable cause){
        super(message,cause);
    }
}
