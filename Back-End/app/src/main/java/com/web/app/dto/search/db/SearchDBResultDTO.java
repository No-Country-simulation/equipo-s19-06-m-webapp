package com.web.app.dto.search.db;

public record SearchDBResultDTO(
         Long id,
         String title,
         String duration,
         Integer preview,

         ArtistDTO artist,
         AlbumDTO album
) {

//    public SearchDBResultDTO(String id, String title, String duration, String preview) {
//        this(id, title, duration, preview, null, null);
//    }
}
