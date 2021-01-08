package com.virtusa.taskservice.exception;

import com.virtusa.common.responsehandle.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException runtimeException, HttpStatus httpStatus, WebRequest webRequest) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimeStamp(new Date().toString());
        errorResponse.setMessage(runtimeException.getMessage());
        errorResponse.setPath(webRequest.getDescription(false));
        errorResponse.setStatus(httpStatus.value());
        errorResponse.setError(httpStatus.getReasonPhrase());

        return new ResponseEntity<ErrorResponse>(errorResponse, httpStatus);
    }


    //if is want use this commented Override method -  extends ResponseEntityExceptionHandler
    /*@Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimeStamp(new Date().toString());
        errorResponse.setMessage(ex.getRootCause().getLocalizedMessage());
        errorResponse.setStatus(status.toString());
        errorResponse.setPath(request.toString());
        errorResponse.setError(status.getReasonPhrase());
        return new ResponseEntity(errorResponse, headers, status);

    }*/


}
