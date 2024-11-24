package com.web.album.album;

public record AlbumWithoutTracksResponse (
        Long id,
        String name,
        String releaseDate,
//        List<String> genres,
        String urlImg
) {
}