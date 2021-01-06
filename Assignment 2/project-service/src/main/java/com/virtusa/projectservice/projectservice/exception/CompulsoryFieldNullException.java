package com.virtusa.projectservice.projectservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CompulsoryFieldNullException extends RuntimeException {

    public CompulsoryFieldNullException(String message) {
        super(message);
    }


    public CompulsoryFieldNullException(String message, Throwable cause) {
        super(message, cause);
    }


}
