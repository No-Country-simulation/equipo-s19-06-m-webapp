package com.web.track.dto.track;

import  com.web.track.dto.album.AlbumResponse;
public record TrackResponse(
        long id,
        String name,
        int duration,
        String previewUrl,
        AlbumResponse album
) {
}
