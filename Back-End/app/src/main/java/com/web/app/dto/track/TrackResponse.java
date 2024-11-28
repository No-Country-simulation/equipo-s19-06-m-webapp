package com.web.app.dto.track;

import com.web.app.dto.album.ShortAlbumResponse;

public record TrackResponse(
        long id,
        String name,
        int duration,
        String previewUrl,
        ShortAlbumResponse album
) {
}
