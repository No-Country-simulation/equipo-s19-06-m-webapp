package com.web.app.util;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Component
public class UriUtil {

    public String getBaseUri() {
        return ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
    }

    public URI buildResourceUri(String resourcePath) {
        return URI.create(getBaseUri() + resourcePath);
    }
}

