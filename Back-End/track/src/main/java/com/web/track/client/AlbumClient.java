package com.web.track.client;

import com.web.track.dto.album.AlbumRequest;
import com.web.track.dto.album.AlbumResponse;
import com.web.track.dto.ExtendedBaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "album-service",
        url = "http://localhost:8070/albums"
)
public interface AlbumClient {

    @GetMapping("/{id}")
    ExtendedBaseResponse<AlbumResponse> findAlbum(@PathVariable Long id);

    @PostMapping
    void createDeezerAlbum(@RequestBody AlbumRequest albumRequest);
}