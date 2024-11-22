package com.web.album.album;

import com.web.album.song.SongResponse;

import java.util.List;

public record AlbumResponse (
        Long id,
        String name,
        String releaseDate,
        List<String> genres,
        String urlImg,
        List<SongResponse> songs
) {
}
