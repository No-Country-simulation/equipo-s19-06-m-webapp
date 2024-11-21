package com.web.album.album;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumMapper {

    public Album toAlbum(AlbumDeezerResponse response){
        return Album.builder()
                .id(response.id())
                .name(response.title())
                .releaseDate(response.release_date())
                .urlImg(response.cover())
                .build();
    }
}
