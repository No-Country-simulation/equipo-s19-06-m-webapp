package com.web.app.dto.deezer.artist;

public record ArtistDeezerResponse(
        Long id,
        String name,
        String link,
        String share,
        String picture,
        String picture_small,
        String picture_medium,
        String picture_big,
        String picture_xl,
        Long nb_album,
        Long nb_fan,
        boolean radio,
        String tracklist,
        String type
) {}

