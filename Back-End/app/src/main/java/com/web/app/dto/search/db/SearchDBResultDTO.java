package com.web.app.dto.search.db;

public record SearchDBResultDTO(
         Long id,
         String title,
         Integer duration,
         String preview,

         ArtistDTO artist,
         AlbumDTO album
) {
}
