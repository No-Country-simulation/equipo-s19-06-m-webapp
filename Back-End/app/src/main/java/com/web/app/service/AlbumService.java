package com.web.app.service;

import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.album.AlbumRequest;
import com.web.app.dto.album.AlbumResponse;

public interface AlbumService {
    ExtendedBaseResponse<AlbumResponse> createDeezerAlbum(AlbumRequest request);
}