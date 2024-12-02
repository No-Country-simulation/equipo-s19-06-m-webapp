package com.web.app.dto.album;

import com.web.app.dto.artist.ShortArtistResponse;

import java.time.LocalDate;
import java.util.List;

public record ShortAlbumResponse(
        Long id,
        String name,
        String releaseDate,
        String pictureUrl,
        List<String> genres,
        ShortArtistResponse artist
) {
}