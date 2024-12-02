package com.web.app.service;

import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.album.AlbumResponse;
import com.web.app.dto.track.TrackRequest;
import com.web.app.dto.track.TrackResponse;

import java.io.IOException;
import java.net.URI;
import java.util.List;

public interface TrackService {
    ExtendedBaseResponse<URI> createDeezerTrack(long id);

    ExtendedBaseResponse<TrackResponse> findTrack(long id);

}
