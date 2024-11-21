package com.web.album.deezer;

public record ContributorAPIResponse(
        Long id,
        String name,
        String link,
        String share,
        String picture,
        String picture_small,
        String picture_medium,
        String picture_big,
        String picture_xl,
        boolean radio,
        String tracklist,
        String type,
        String role
) {}

