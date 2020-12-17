package com.virtusa.ExceptionHandler.exeption;

public class InvalidVehicleCategoryException extends RuntimeException {


    public InvalidVehicleCategoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
