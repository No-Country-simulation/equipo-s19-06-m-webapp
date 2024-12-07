package com.web.app.dto.album;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web.app.dto.artist.ArtistSummaryResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;


public record AlbumSummaryResponse(
        @Schema(example = "15103893")
        Long id,

        @Schema(example = "Faded")
        String name,

        @Schema(example = "2015-12-04")
        String releaseDate,

        @Schema(example = "https://api.deezer.com/album/15103893/image")
        String picture_url,

        @ArraySchema(schema = @Schema(example = "Electro"))
        String genre,

        @JsonIgnore
        ArtistSummaryResponse artist
) {
}