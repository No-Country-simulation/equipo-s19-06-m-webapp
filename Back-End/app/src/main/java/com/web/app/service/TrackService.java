package com.web.app.service;

import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.track.TrackRequest;
import com.web.app.dto.track.TrackResponse;

import java.io.IOException;
import java.util.List;

public interface TrackService {
    ExtendedBaseResponse<TrackResponse> createDeezerTrack(TrackRequest request);
}
