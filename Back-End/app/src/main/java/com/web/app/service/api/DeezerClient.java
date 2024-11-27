package com.web.app.service.api;

import com.web.app.dto.deezer.album.AlbumDeezerResponse;
import com.web.app.dto.deezer.track.TrackDeezerResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeezerClient {

    private final String url = "https://api.deezer.com/";

    public AlbumDeezerResponse findAlbumById(Long id) {
        RestTemplate template = new RestTemplate();
        return template.getForObject(url + "album/" + id, AlbumDeezerResponse.class);
    }

    public TrackDeezerResponse findTrackById(Long id) {
        RestTemplate template = new RestTemplate();
        return template.getForObject(url + "track/" + id, TrackDeezerResponse.class);
    }
}
