package com.web.app.service.impl;

import com.web.app.exception.albumExc.AlbumNotFoundException;
import com.web.app.service.api.DeezerClient;
import com.web.app.dto.BaseResponse;
import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.album.AlbumRequest;
import com.web.app.dto.album.AlbumResponse;
import com.web.app.dto.deezer.album.AlbumDeezerResponse;
import com.web.app.dto.deezer.track.TrackDeezerResponse;
import com.web.app.dto.deezer.track.TracksDeezerResponse;
import com.web.app.dto.track.TrackRequest;
import com.web.app.mapper.AlbumMapper;
import com.web.app.mapper.AlbumTrackMapper;
import com.web.app.model.Album;
import com.web.app.repository.AlbumRepository;
import com.web.app.service.AlbumService;
import com.web.app.service.TrackService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;
    private final AlbumTrackMapper albumTrackMapper;
    private final DeezerClient deezerClient;
    private final TrackService trackService;

    // Trae un album con todas las pistas del Api Deezer
    @Transactional
    public ExtendedBaseResponse<AlbumResponse> createDeezerAlbum(AlbumRequest request) {
        // Busca el album en la Api Deezer
        AlbumDeezerResponse albumDeezerResponse = deezerClient.findAlbumById(request.id());
        if(albumDeezerResponse.id() == null)
            throw new AlbumNotFoundException("Album no encontrado para id: " + request.id());

        // Crea todas las pistas del album
        TracksDeezerResponse tracksDeezerResponse = albumDeezerResponse.tracks();
        for(TrackDeezerResponse trackDeezerResponse: tracksDeezerResponse.data()) {
            TrackRequest trackRequest = new TrackRequest(trackDeezerResponse.id());
            trackService.createDeezerTrack(trackRequest);
        }

        // Busca el album creado
        Album album = albumRepository.findById(request.id())
                .orElseThrow(() -> new AlbumNotFoundException("Album no encontrado para id: " + request.id()));

        AlbumResponse response = albumTrackMapper.toAlbumResponse(album);
        return ExtendedBaseResponse.of(
                BaseResponse.created("Album creado."),
                response
        );
    }
}
