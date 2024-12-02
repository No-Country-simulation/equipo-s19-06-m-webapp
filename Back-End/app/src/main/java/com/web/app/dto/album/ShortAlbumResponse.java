package com.web.app.dto.album;

import com.web.app.dto.artist.ShortArtistResponse;
import com.web.app.dto.track.ShortTrackResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.List;

public record ShortAlbumResponse(
        @Schema(example = "15103893")
        Long id,

        @Schema(example = "Faded")
        String name,

        @Schema(example = "2015-12-04")
        String releaseDate,

        @Schema(example = "https://api.deezer.com/album/15103893/image")
        String pictureUrl,

        @ArraySchema(schema = @Schema(examples = {"Electro", "Techno/House", "Dance"}))
        List<String> genres,

        ShortArtistResponse artist
) {
}