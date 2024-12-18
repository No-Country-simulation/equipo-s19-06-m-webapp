package com.web.app.dto.album;

import com.web.app.dto.artist.ArtistSummaryResponse;
import com.web.app.dto.track.TrackSummaryResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;


public record AlbumResponse (
        @Schema(example = "15103893")
        Long id,

        @Schema(example = "Faded")
        String name,

        @Schema(example = "2015-12-04")
        String releaseDate,

        @Schema(example = "https://api.deezer.com/album/15103893/image")
        String pictureUrl,

        @ArraySchema(schema = @Schema(example = "Electro"))
        List<String> genres,

        ArtistSummaryResponse artist,

        List<TrackSummaryResponse> tracks
) {
}