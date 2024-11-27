package com.web.app.dto.album;

import com.web.app.dto.track.TrackResponse;

import java.util.List;

public record AlbumResponse (
        Long id,
        String name,
        String releaseDate,
//        List<String> genres,
        String pictureUrl,
        List<TrackResponse> tracks
) {
}
