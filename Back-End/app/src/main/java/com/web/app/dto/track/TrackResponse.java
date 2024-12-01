package com.web.app.dto.track;

import com.web.app.dto.album.ShortAlbumResponse;
import com.web.app.dto.artist.ShortArtistResponse;

public record TrackResponse(
        long id,
        String name,
        int duration,
        String previewUrl,
        ShortAlbumResponse album
) {
}
