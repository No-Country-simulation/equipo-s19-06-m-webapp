package com.web.album.dto.deezer;

import java.util.List;

public record TracksDeezerResponse(
        List<TrackDeezerResponse> data
) {}