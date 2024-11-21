package com.web.song.album;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "album-service",
        url = "http://localhost:8070/albums"
)
public interface AlbumClient {

    @PostMapping
    void createAlbum(@RequestBody AlbumRequest albumRequest);
}
