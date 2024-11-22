package com.web.album.song;

import java.util.List;

public record TracksDeezerResponse(
        List<TrackDeezerResponse> data
) {}