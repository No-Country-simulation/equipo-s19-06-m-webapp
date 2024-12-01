package com.web.app.exception.albumExc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AlbumNotFoundException extends RuntimeException{
    public AlbumNotFoundException(String msg) {
        super(msg);
    }
}
