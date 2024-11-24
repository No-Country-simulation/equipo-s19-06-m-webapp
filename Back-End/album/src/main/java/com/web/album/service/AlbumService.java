package com.web.album.service;

import com.web.album.dto.BaseResponse;
import com.web.album.dto.ExtendedBaseResponse;
import com.web.album.client.DeezerClient;
import com.web.album.dto.album.AlbumRequest;
import com.web.album.dto.album.AlbumResponse;
import com.web.album.dto.album.AlbumWithoutTracksResponse;
import com.web.album.dto.deezer.AlbumDeezerResponse;
import com.web.album.dto.deezer.TrackDeezerResponse;
import com.web.album.dto.track.TrackRequest;
import com.web.album.dto.deezer.TracksDeezerResponse;
import com.web.album.model.Album;
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

            TracksDeezerResponse tracksDeezerResponse = albumDeezerResponse.tracks();
            for(TrackDeezerResponse response: tracksDeezerResponse.data()) {
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
