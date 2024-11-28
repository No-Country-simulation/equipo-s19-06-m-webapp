package com.web.app.dto.track;

public record ShortTrackResponse(
        long id,
        String name,
        int duration,
        String previewUrl
) {
}