package com.web.song.song;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongMapper {
    public Song toSong(SongDeezerResponse response){
        return Song.builder()
                .id(response.id())
                .name(response.title())
                .duration(response.duration())
                .albumId(response.album().id())
                .url(response.preview())
                .build();
    }
}
