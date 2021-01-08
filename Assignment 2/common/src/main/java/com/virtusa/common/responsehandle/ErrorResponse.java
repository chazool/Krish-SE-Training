package com.virtusa.common.responsehandle;

import lombok.Data;

@Data
public class ErrorResponse {

    private String error;
    private String timeStamp;
    private int status;
    private Object message;
    private String path;


}
