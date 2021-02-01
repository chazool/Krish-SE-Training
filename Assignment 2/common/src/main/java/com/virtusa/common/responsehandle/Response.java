package com.chazool.common.responsehandle;

import lombok.Data;

@Data
public class Response {

    private enum Status {
        SUCCESS, FAIL
    }

    public Response() {
    }

    private Response(Status status, Object data) {
        this.status = status;
        this.data = data;
    }


    private Status status;
    private Object data;

    public Response success(Object data) {
        return new Response(Status.SUCCESS, data);
    }

    public Response fail(Object data) {
        return new Response(Status.FAIL, data);
    }

}
