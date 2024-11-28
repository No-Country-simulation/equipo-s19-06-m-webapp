package com.web.app.mapper;

import com.web.app.dto.album.ShortAlbumResponse;
import com.web.app.model.Album;
import com.web.app.model.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumMapper {

    public ShortAlbumResponse toAlbumWithoutTracksResponse(Album album) {
        return new ShortAlbumResponse(
                album.getId(),
                album.getName(),
                album.getReleaseDate(),
                album.getGenres().stream().map(Genre::getName).toList(),
                album.getPictureUrl()
        );
    }
}
