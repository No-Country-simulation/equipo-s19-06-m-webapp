package com.web.app.dto.track;

import com.web.app.dto.album.AlbumSummaryResponse;
import com.web.app.dto.artist.ArtistSummaryResponse;
import io.swagger.v3.oas.annotations.media.Schema;

public record TrackResponse(
        @Schema(example = "140295501")
        long id,

        @Schema(example = "Faded")
        String title,

        @Schema(example = "212")
        int duration,

        @Schema(example = "http://res.cloudinary.com/dcfondn1f/video/upload/v1732652495/tracks/140295501.mp3")
        String preview,
        ArtistSummaryResponse artist,
        AlbumSummaryResponse album
) {
}
