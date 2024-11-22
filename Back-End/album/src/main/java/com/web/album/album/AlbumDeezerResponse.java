package com.web.album.album;

import com.web.album.song.TracksDeezerResponse;

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
        String release_date,
        String tracklist,
        String type,
        TracksDeezerResponse tracks
) {}