package com.web.album.album;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumMapper {
//    private final AlbumMapper albumMapper;

    public Album toAlbum(AlbumAPIResponse response){
        return Album.builder()
                .id(response.id())
                .nombre(response.title())
//                .fechaLanzamiento(response.release_date())
//                .album(albumMapper.toAlbum(response.album()))
                .urlImg(response.cover())
                .build();
    }
}
