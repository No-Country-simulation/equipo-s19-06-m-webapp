package com.web.song.song;

import com.web.song.base.ExtendedBaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService service;

    @PostMapping
    public ExtendedBaseResponse<SongResponse> createDeezerSong (@RequestBody SongRequest request) {
        return service.createDeezerSong(request);
    }

}
