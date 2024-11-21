package com.web.app.dto;

import java.util.List;

public record CancionAPIResponse(
        Long id,
        boolean readable,
        String title,
        String title_short,
        String title_version,
        String isrc,
        String link,
        String share,
        int duration,
        int track_position,
        int disk_number,
        int rank,
        String release_date,
        boolean explicit_lyrics,
        int explicit_content_lyrics,
        int explicit_content_cover,
        String preview,
        double bpm,
        double gain,
        List<String> available_countries,
        List<ContributorAPIResponse> contributors,
        String md5_image,
        String track_token,
        ArtistaAPIResponse artist,
        AlbumAPIResponse album
) {}
