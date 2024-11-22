package com.web.song.song;

import com.web.song.album.AlbumResponse;
import jakarta.persistence.Column;

public record SongResponse(
        long id,
        String name,
        int duration,
        String urlPreview,
        AlbumResponse album
) {
}
