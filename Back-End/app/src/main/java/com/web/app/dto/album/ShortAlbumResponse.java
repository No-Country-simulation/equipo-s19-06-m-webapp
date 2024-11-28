package com.web.app.dto.album;

import java.util.List;

public record ShortAlbumResponse(
        Long id,
        String name,
        String releaseDate,
        List<String> genres,
        String pictureUrl
) {
}