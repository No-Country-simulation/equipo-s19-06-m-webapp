package com.web.track.service;

import com.web.track.dto.ExtendedBaseResponse;
import com.web.track.dto.track.TrackRequest;
import com.web.track.dto.track.TrackResponse;

import java.io.IOException;
import java.util.List;

public interface TrackService {
    ExtendedBaseResponse<List<TrackResponse>> findTracksByAlbumId(Long albumId);
    ExtendedBaseResponse<TrackResponse> createDeezerTrack(TrackRequest request) throws IOException;
}
