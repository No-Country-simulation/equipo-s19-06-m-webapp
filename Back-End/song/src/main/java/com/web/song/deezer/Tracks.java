package com.web.song.deezer;

import com.web.song.song.SongDeezerResponse;

import java.util.List;

public record Tracks(
        List<SongDeezerResponse> data
) {}