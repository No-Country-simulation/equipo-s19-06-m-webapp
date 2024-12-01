package com.web.app.dto.artist;

public record ShortArtistResponse(
        Long id,
        String name,
        String pictureUrl,
        Long fanNum
) {}