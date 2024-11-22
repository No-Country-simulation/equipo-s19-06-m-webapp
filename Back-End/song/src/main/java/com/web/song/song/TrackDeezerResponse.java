package com.web.song.song;

import com.web.song.album.AlbumDeezerResponse;
import com.web.song.artist.ArtistDeezerResponse;
import com.web.song.deezer.ContributorDeezerResponse;

import java.util.List;

public record TrackDeezerResponse(
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
        List<ContributorDeezerResponse> contributors,
        String md5_image,
        String track_token,
        ArtistDeezerResponse artist,
        AlbumDeezerResponse album
) {}
