package com.web.track.dto.album;

public record AlbumResponse(
        Long id,
        String name,
        String releaseDate,
        String pictureUrl
) {
}
