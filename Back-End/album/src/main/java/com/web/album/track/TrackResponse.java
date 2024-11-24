package com.web.album.track;

public record TrackResponse(
        Long id,
        String name,
        int duration,
        String previewUrl
) {
}
