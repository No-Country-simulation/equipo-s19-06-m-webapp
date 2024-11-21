package com.web.album.deezer;

import com.web.album.album.AlbumDeezerResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeezerClient {

    private final String url = "https://api.deezer.com/";

    public AlbumDeezerResponse findAlbumById(Long id) {
        RestTemplate template = new RestTemplate();
        return template.getForObject(url + "album/" + id, AlbumDeezerResponse.class);
    }
}
