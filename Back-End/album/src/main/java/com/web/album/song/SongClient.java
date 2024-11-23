package com.web.album.song;

import com.web.album.base.ExtendedBaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "song-service",
        url = "http://localhost:8060/songs"
)
public interface SongClient {

    @GetMapping("/{albumId}")
    ExtendedBaseResponse<List<SongResponse>> findSongsByAlbumId(Long albumId);

    @PostMapping
    void createSong(@RequestBody SongRequest songRequest);
}
