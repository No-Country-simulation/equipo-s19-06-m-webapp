package com.web.song.deezer;

import com.web.song.song.CancionAPIResponse;

import java.util.List;

public record Tracks(
        List<CancionAPIResponse> data
) {}