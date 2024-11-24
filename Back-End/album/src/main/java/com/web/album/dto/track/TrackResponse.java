package com.web.album.dto.track;

public record TrackResponse(
        Long id,
        String name,
        int duration,
        String previewUrl
) {
}
