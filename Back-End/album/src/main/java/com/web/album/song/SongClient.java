package com.web.album.song;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "song-service",
        url = "http://localhost:8060/songs"
)
public interface SongClient {
    @PostMapping
    void addAlbum(@RequestBody CancionRequest cancionRequest);
}
