package com.web.app.service.api;

import com.web.app.dto.deezer.album.AlbumDeezerResponse;
import com.web.app.dto.deezer.artist.ArtistDeezerResponse;
import com.web.app.dto.deezer.track.TrackDeezerResponse;
import com.web.app.dto.search.SearchDeezerResponse;
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

    public ArtistDeezerResponse findArtistById(Long id) {
        RestTemplate template = new RestTemplate();
        return template.getForObject(url + "artist/" + id, ArtistDeezerResponse.class);
    }

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
