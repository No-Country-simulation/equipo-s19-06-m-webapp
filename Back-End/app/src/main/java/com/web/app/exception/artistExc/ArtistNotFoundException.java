package com.web.app.exception.artistExc;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ArtistNotFoundException extends RuntimeException{
    public ArtistNotFoundException(String msg) {
        super(msg);
    }
}
