package com.web.album.song;

import jakarta.persistence.Column;

public record SongResponse(
        Long id,
        String name,
        int duration,
        String urlPreview
) {
}
