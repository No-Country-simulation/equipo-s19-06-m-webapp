package com.web.app.dto.search.db;

import io.swagger.v3.oas.annotations.media.Schema;

public interface SearchDBResponseProjection {
    @Schema(example = "Nueva Era")
    String getTrack();
    @Schema(example = "AMERI")
    String getAlbum();
    @Schema(example = "DUKI")
    String getArtist();
    @Schema(example = "https://api.deezer.com/album/664113131/image")
    String getPicture_url();
    @Schema(example = "track")
    String getType();
    @Schema(example = "3069012151")
    Long getId();
}
