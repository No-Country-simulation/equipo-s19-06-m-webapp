package com.web.song.album;

import org.springframework.stereotype.Service;

@Service
public class AlbumMapper {
    public AlbumResponse toAlbumResponse(AlbumDeezerResponse albumDeezerResponse) {
        return new AlbumResponse(
                albumDeezerResponse.id(),
                albumDeezerResponse.title(),
                albumDeezerResponse.release_date(),
                albumDeezerResponse.cover()
        );
    }
}
