package com.virtusa.singleton.exception;

public class ConfigFileNotFoundException extends RuntimeException {

    public ConfigFileNotFoundException(String message, Throwable cause){
        super(message,cause);
    }
}
