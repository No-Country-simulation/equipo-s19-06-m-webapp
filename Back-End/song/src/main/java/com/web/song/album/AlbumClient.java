package com.web.song.album;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "album-service",
        url = "http://localhost:8060/albums"
)
public interface AlbumClient {

    @PostMapping
    void addAlbum(@RequestBody AlbumRequest albumRequest);
}
