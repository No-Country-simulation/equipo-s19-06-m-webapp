package com.web.album.dto;

public record TrackResponse(
        Long id,
        String name,
        int duration,
        String previewUrl
) {
}
