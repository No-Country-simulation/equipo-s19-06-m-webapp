package com.web.song.base;

public record ExtendedBaseResponse<T>(
        boolean isError,
        int code,
        String status,
        String message,
        T data
) {
    public static <T> ExtendedBaseResponse<T> of(BaseResponse baseResponse, T data) {
        return new ExtendedBaseResponse<>(
                baseResponse.isError(),
                baseResponse.getStatusCode(),
                baseResponse.getStatusName(),
                baseResponse.message(),
                data
        );
    }

}

