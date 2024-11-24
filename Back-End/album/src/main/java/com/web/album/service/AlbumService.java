package com.web.album.service;

import com.web.album.base.BaseResponse;
import com.web.album.base.ExtendedBaseResponse;
import com.web.album.client.DeezerClient;
import com.web.album.client.TrackClient;
import com.web.album.dto.*;
import com.web.album.mapper.AlbumMapper;
import com.web.album.model.Album;
import com.web.album.repository.AlbumRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final com.web.album.repository.AlbumRepository albumRepository;
    private final com.web.album.mapper.AlbumMapper albumMapper;
    private final com.web.album.client.TrackClient trackClient;
    private final DeezerClient deezerClient;

    public ExtendedBaseResponse<AlbumWithoutTracksResponse> findAlbumWithoutTracks(Long id) {
        Album album = albumRepository.findById(id).orElseGet(()-> {
            AlbumDeezerResponse albumDeezerResponse = deezerClient.findAlbumById(id);

            if(albumDeezerResponse.id() == null)
                throw new EntityNotFoundException("Album no encontrado.");

            return albumMapper.toAlbum(albumDeezerResponse);
        });
        AlbumWithoutTracksResponse albumResponse = albumMapper.toAlbumWithoutTracksResponse(album);
        return ExtendedBaseResponse.of(
                BaseResponse.ok("Album encontrado."),
                albumResponse
        );
    }

    public ExtendedBaseResponse<AlbumResponse> createDeezerAlbum(AlbumRequest request) {
        Album album = albumRepository.findById(request.id()).orElseGet(() -> {
            AlbumDeezerResponse albumDeezerResponse = deezerClient.findAlbumById(request.id());

            if(albumDeezerResponse.id() == null)
                throw new EntityNotFoundException("Album no encontrado.");

            Album deezerAlbum = albumMapper.toAlbum(albumDeezerResponse);
            albumRepository.save(deezerAlbum);

            com.web.album.dto.TracksDeezerResponse tracksDeezerResponse = albumDeezerResponse.tracks();
            for(com.web.album.dto.TrackDeezerResponse response: tracksDeezerResponse.data()) {
                TrackRequest trackRequest = new TrackRequest(response.id());
                trackClient.createTrack(trackRequest);
            }
            return deezerAlbum;
        });

        AlbumResponse response = albumMapper.toAlbumResponse(album);

        return ExtendedBaseResponse.of(
                BaseResponse.created("Album creado."),
                response
        );
    }
}
