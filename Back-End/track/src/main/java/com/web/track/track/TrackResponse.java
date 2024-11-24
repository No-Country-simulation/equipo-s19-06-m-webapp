package com.web.track.track;

import com.web.track.album.AlbumResponse;

public record TrackResponse(
        long id,
        String name,
        int duration,
        String urlPreview,
        AlbumResponse album
) {
}
