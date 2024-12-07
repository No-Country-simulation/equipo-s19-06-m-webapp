package com.web.app.dto.track;

import com.web.app.dto.album.AlbumSummaryResponse;
import io.swagger.v3.oas.annotations.media.Schema;

public record TrackResponse(
        @Schema(example = "140295501")
        long id,

        @Schema(example = "Faded")
        String name,

        @Schema(example = "212")
        int duration,

        @Schema(example = "http://res.cloudinary.com/dcfondn1f/video/upload/v1732652495/tracks/140295501.mp3")
        String previewUrl,

        AlbumSummaryResponse album
) {
}
