package com.web.song.song;

import com.web.song.base.ExtendedBaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService service;

    @GetMapping("/album/{albumId}")
    public ExtendedBaseResponse<List<SongResponse>> findSongsByAlbumId(@PathVariable Long albumId) {
        return service.findSongsByAlbumId(albumId);
    }

    @PostMapping
    public ExtendedBaseResponse<SongResponse> createDeezerSong (@RequestBody SongRequest request) {
        return service.createDeezerSong(request);
    }

}
