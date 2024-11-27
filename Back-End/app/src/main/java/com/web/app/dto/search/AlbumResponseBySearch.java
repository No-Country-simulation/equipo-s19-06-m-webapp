package com.web.app.dto.search;

public record AlbumResponseBySearch(
        long id,
        String title,
        String cover,
        String cover_small,
        String cover_medium,
        String cover_big,
        String cover_xl,
        String md5_image,
        String tracklist
//    String type
) {
}
