package com.web.app.dto;

import org.springframework.http.HttpStatus;

public record BaseResponse(
        boolean isError,
        HttpStatus status,
        String message
) {

    public BaseResponse(boolean isError, int code, String status, String message) {
        this(isError, HttpStatus.valueOf(code), message);
    }

    public static Object badRequest(String message) {
        return new BaseResponse(true, HttpStatus.BAD_REQUEST, message);
    }

    public int getStatusCode() {
        return status.value();
    }

    public String getStatusName() {
        return status.getReasonPhrase();
    }

    public static BaseResponse created(String message) {
        return new BaseResponse(false, HttpStatus.CREATED, message);
    }

    public static BaseResponse ok(String message) {
        return new BaseResponse(false, HttpStatus.OK, message);
    }

}

