package com.web.track.deezer;

import com.web.track.track.TrackDeezerResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeezerClient {

    private final String url = "https://api.deezer.com/";

    public TrackDeezerResponse findTrackById(Long id) {
        RestTemplate template = new RestTemplate();
        return template.getForObject(url + "track/" + id, TrackDeezerResponse.class);
    }
}
