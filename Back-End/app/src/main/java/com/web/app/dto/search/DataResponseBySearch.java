package com.web.app.dto.search;

import lombok.AllArgsConstructor;

public record DataResponseBySearch(
        long id,
//        boolean readable,
        String title,
        String title_short,
//        String title_version,
//        String link,
        int duration,
//        int rank,
//        boolean explicit_lyrics,
//        int explicit_content_lyrics,
//        int explicit_content_cover,
        String preview,
        String md5_image,
        ArtistResponseBySearch artist,
        AlbumResponseBySearch album
) {
}
