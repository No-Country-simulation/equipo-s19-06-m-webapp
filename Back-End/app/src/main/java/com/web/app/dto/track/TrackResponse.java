package com.web.app.dto.track;

import com.web.app.dto.album.AlbumWithoutTracksResponse;

public record TrackResponse(
        long id,
        String name,
        int duration,
        String previewUrl,
        AlbumWithoutTracksResponse album
) {
}
