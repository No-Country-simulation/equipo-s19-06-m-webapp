package com.web.album.deezer;

import com.web.album.album.AlbumAPIResponse;
import com.web.album.song.CancionAPIResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeezerApiClient {

    private String url = "https://api.deezer.com/";

    public AlbumAPIResponse buscarAlbumn(Long id) {
        RestTemplate template = new RestTemplate();
        return template.getForObject(url + "album/" + id, AlbumAPIResponse.class);
    }
}
