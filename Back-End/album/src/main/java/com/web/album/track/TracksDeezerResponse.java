package com.web.album.track;

import java.util.List;

public record TracksDeezerResponse(
        List<TrackDeezerResponse> data
) {}