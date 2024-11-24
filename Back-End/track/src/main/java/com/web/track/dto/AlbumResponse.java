package com.web.track.dto;

public record AlbumResponse(
        Long id,
        String name,
        String releaseDate,
        String pictureUrl
) {
}
