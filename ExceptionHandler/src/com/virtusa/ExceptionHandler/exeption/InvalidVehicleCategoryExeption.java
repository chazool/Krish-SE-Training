package com.virtusa.ExceptionHandler.exeption;

public class InvalidVehicleCategoryExeption extends  RuntimeException{


    static final long serialVersionUID = -1;
    public  InvalidVehicleCategoryExeption(String message,Throwable cause){
        super(message,cause);
    }
}
