package com.virtusa.ExceptionHandler.exeption;

public class SqlOpprationExeption extends RuntimeException{


    static final long serialVersionUID = -1;
    public  SqlOpprationExeption(String message,Throwable cause){
        super(message,cause);
    }
}
