package com.web.album.dto;

import com.web.album.dto.TrackDeezerResponse;

import java.util.List;

public record TracksDeezerResponse(
        List<TrackDeezerResponse> data
) {}