package com.web.album.dto;

import org.springframework.http.HttpStatus;

public record BaseResponse(
        boolean isError,
        HttpStatus status,
        String message
) {

    public BaseResponse(boolean isError, int code, String status, String message) {
        this(isError, HttpStatus.valueOf(code), message);
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
