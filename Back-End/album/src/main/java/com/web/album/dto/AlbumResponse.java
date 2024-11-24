package com.web.album.dto;

import com.web.album.dto.TrackResponse;

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
