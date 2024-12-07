package com.web.app.dto.artist;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record ArtistSummaryResponse(
        @Schema(example = "4999707")
        Long id,

        @Schema(example = "Alan Walker")
        String name,


        @Schema(example = "https://api.deezer.com/artist/4999707/image")
        @JsonProperty("picture_url")
        String pictureUrl,

        @Schema(example = "3914389")
        Long fanNum
) {}