package com.web.song.deezer;

import com.web.song.song.SongDeezerResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeezerClient {

    private final String url = "https://api.deezer.com/";

    public SongDeezerResponse findSongById(Long id) {
        RestTemplate template = new RestTemplate();
        return template.getForObject(url + "track/" + id, SongDeezerResponse.class);
    }
}
