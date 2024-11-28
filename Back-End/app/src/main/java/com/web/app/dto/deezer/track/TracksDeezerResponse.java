package com.web.app.dto.deezer.track;

import java.util.List;

public record TracksDeezerResponse(
        List<TrackDeezerResponse> data
) {}