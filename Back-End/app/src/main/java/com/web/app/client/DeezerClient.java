package com.web.app.client;

import com.web.app.dto.search.SearchDeezerResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeezerClient {

    private final String url = "https://api.deezer.com/";

    public SearchDeezerResponse searchDeezerAPI(String artist, String track, String album) {
        RestTemplate template = new RestTemplate();
        return template.getForObject(url + "search?q="
//      con comillas o que las agreguen al hacer la peticion
//      creo que al hacer las peticiones son un buen indicador de
                + "artist:" + artist
                + " track:" + track
                + " album:" + album

//                        + "artist:" + "\"" + artist + "\""
//                        + " track:" + "\"" + track + "\""
//                        + " album:" + "\"" + album + "\""
                , SearchDeezerResponse.class);
    }
}
