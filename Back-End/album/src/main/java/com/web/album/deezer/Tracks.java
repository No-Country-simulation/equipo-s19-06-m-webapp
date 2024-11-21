package com.web.album.deezer;

import com.web.album.song.CancionAPIResponse;

import java.util.List;

public record Tracks(
        List<CancionAPIResponse> data
) {}