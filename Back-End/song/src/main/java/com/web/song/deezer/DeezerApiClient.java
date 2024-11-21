package com.web.song.deezer;

import com.web.song.album.AlbumAPIResponse;
import com.web.song.song.CancionAPIResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeezerApiClient {

    private String url = "https://api.deezer.com/";

    public CancionAPIResponse buscarCancion(Long id) {
        RestTemplate template = new RestTemplate();
        return template.getForObject(url + "track/" + id, CancionAPIResponse.class);
    }

    public AlbumAPIResponse buscarAlbumn(Long id) {
        RestTemplate template = new RestTemplate();
        return template.getForObject(url + "album/" + id, AlbumAPIResponse.class);
    }
}
