package com.web.album.dto.album;

import com.web.album.dto.track.TrackResponse;

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
