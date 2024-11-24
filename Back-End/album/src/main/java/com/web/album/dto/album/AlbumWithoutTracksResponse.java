package com.web.album.dto.album;

public record AlbumWithoutTracksResponse (
        Long id,
        String name,
        String releaseDate,
//        List<String> genres,
        String pictureUrl
) {
}