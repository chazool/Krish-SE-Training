package com.virtusa.singleton.exception;

public class ConfigFileReadWriteException extends RuntimeException {

    public ConfigFileReadWriteException(String message) {
        super(message);

    }

    public ConfigFileReadWriteException(String message, Throwable cause) {
        super(message, cause);

    }
}
