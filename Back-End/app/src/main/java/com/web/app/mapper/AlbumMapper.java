package com.web.app.mapper;

import com.web.app.dto.album.AlbumWithoutTracksResponse;
import com.web.app.model.Album;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumMapper {

    public AlbumWithoutTracksResponse toAlbumWithoutTracksResponse(Album album) {
        return new AlbumWithoutTracksResponse(
                album.getId(),
                album.getName(),
                album.getReleaseDate(),
//                album.getGenres(),
                album.getPictureUrl()
        );
    }
}
