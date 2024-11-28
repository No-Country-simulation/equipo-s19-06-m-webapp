package com.web.app.dto.search;

public record ArtistResponseBySearch(
        String id,
        String name,
//        String link,
        String picture,
        String picture_small,
        String picture_medium,
        String picture_big,
        String picture_xl,
        String tracklist
//        String type
) {
}
