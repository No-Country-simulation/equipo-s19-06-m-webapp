package com.web.song.song;

import java.util.List;

public record TracksDeezerResponse(
        List<TrackDeezerResponse> data
) {}