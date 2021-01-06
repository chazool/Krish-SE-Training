package com.virtusa.projectservice.projectservice.exception;

import com.virtusa.projectservice.projectservice.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimeStamp(new Date().toString());
        errorResponse.setMessage(ex.getRootCause().getLocalizedMessage());
        errorResponse.setStatus(status.toString());
        errorResponse.setPath(request.getContextPath());
        errorResponse.setError(status.getReasonPhrase());
        return new ResponseEntity(errorResponse, headers, status);
    }
}
