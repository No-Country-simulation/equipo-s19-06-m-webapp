package com.web.app.dto.album;

import com.web.app.dto.artist.ShortArtistResponse;
import com.web.app.dto.track.ShortTrackResponse;
import com.web.app.dto.track.TrackResponse;

import java.time.LocalDate;
import java.util.List;

public record AlbumResponse (
        Long id,
        String name,
        String releaseDate,
        String pictureUrl,
        List<String> genres,
        ShortArtistResponse artist,
        List<ShortTrackResponse> tracks
) {
}
