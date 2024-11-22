package com.web.song.album;

import java.util.List;

public record AlbumResponse(
        Long id,
        String name,
        String releaseDate,
        String urlImg
) {
}
