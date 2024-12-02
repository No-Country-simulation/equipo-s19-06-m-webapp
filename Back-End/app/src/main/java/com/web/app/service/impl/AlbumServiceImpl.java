package com.web.app.service.impl;

import com.web.app.exception.albumExc.AlbumNotFoundException;
import com.web.app.service.api.DeezerClient;
import com.web.app.dto.BaseResponse;
import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.album.AlbumResponse;
import com.web.app.dto.deezer.album.AlbumDeezerResponse;
import com.web.app.dto.deezer.track.TrackDeezerResponse;
import com.web.app.dto.deezer.track.TracksDeezerResponse;
import com.web.app.mapper.AlbumMapper;
import com.web.app.model.Album;
import com.web.app.repository.AlbumRepository;
import com.web.app.service.AlbumService;
import com.web.app.service.TrackService;
import com.web.app.util.UriUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;
    private final DeezerClient deezerClient;
    private final TrackService trackService;
    private final UriUtil uriUtil;

    // Trae un album con el artista y todas las pistas del Api Deezer
    @Transactional
    public ExtendedBaseResponse<URI> createDeezerAlbum(long id) {
        // Busca el album en la Api Deezer
        AlbumDeezerResponse albumDeezerResponse = deezerClient.findAlbumById(id);
        if(albumDeezerResponse.id() == null)
            throw new AlbumNotFoundException("Album no encontrado para id: " + id);

        // Crea todas las pistas del album
        TracksDeezerResponse tracksDeezerResponse = albumDeezerResponse.tracks();
        for(TrackDeezerResponse trackDeezerResponse: tracksDeezerResponse.data()) {
            trackService.createDeezerTrack(trackDeezerResponse.id());
        }

        URI response = uriUtil.buildResourceUri("/albums/" + id);
        return ExtendedBaseResponse.of(
                BaseResponse.created("Album creado."),
                response
        );
    }

    public ExtendedBaseResponse<AlbumResponse> findAlbum(long id) {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new AlbumNotFoundException("Album no encontrado para id: " + id));

        AlbumResponse response = albumMapper.toAlbumResponse(album);
        return ExtendedBaseResponse.of(
                BaseResponse.created("Album encontrado."),
                response
        );
    }
}
