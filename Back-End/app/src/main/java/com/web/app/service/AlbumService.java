package com.web.app.service;

import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.album.AlbumRequest;
import com.web.app.dto.album.AlbumResponse;

import java.net.URI;

public interface AlbumService {
    ExtendedBaseResponse<URI> createDeezerAlbum(long id);

    ExtendedBaseResponse<AlbumResponse> findAlbum(long id);
}
