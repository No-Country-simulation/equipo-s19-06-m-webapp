package com.web.track.dto;

public record TrackResponse(
        long id,
        String name,
        int duration,
        String previewUrl,
        AlbumResponse album
) {
}
