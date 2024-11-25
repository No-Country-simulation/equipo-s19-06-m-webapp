package com.web.album.service;

import com.web.album.dto.ExtendedBaseResponse;
import com.web.album.dto.album.AlbumRequest;
import com.web.album.dto.album.AlbumResponse;
import com.web.album.dto.album.AlbumWithoutTracksResponse;

public interface AlbumService {
    ExtendedBaseResponse<AlbumWithoutTracksResponse> findAlbumWithoutTracks(Long id);
    ExtendedBaseResponse<AlbumResponse> createDeezerAlbum(AlbumRequest request);
}
