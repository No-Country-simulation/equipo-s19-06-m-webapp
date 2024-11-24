package com.web.track.album;

public record AlbumResponse(
        Long id,
        String name,
        String releaseDate,
        String urlImg
) {
}
