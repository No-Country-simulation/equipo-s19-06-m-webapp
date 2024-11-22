package com.web.album.song;

import org.springframework.stereotype.Service;

@Service
public class SongMapper {

    public SongResponse toSongResponse(TrackDeezerResponse trackDeezerResponse) {
        return new SongResponse(
                trackDeezerResponse.id(),
                trackDeezerResponse.title(),
                trackDeezerResponse.duration(),
                trackDeezerResponse.preview()
        );
    }
}
