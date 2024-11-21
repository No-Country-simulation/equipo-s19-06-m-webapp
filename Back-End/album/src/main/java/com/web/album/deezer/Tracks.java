package com.web.album.deezer;

import com.web.album.song.SongDeezerResponse;

import java.util.List;

public record Tracks(
        List<SongDeezerResponse> data
) {}