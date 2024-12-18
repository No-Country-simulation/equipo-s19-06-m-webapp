package com.web.app.dto.deezer.album;

import com.web.app.dto.deezer.genre.GenresDeezerResponse;
import com.web.app.dto.deezer.track.TracksDeezerResponse;

public record AlbumDeezerResponse(
        Long id,
        String title,
        String link,
        String cover,
        String cover_small,
        String cover_medium,
        String cover_big,
        String cover_xl,
        String md5_image,
        GenresDeezerResponse genres,
        String release_date,
        String tracklist,
        String type,
        TracksDeezerResponse tracks
) {}