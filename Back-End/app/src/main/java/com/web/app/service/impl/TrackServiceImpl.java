package com.web.app.service.impl;

import com.web.app.service.api.DeezerClient;
import com.web.app.dto.BaseResponse;
import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.deezer.track.TrackDeezerResponse;
import com.web.app.dto.track.TrackRequest;
import com.web.app.dto.track.TrackResponse;
import com.web.app.mapper.AlbumTrackMapper;
import com.web.app.mapper.TrackMapper;
import com.web.app.model.Track;
import com.web.app.repository.AlbumRepository;
import com.web.app.repository.TrackRepository;
import com.web.app.service.TrackService;
import com.web.app.service.api.CloudinaryService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;
    private final AlbumRepository albumRepository;
    private final AlbumTrackMapper albumTrackMapper;
    private final TrackMapper trackMapper;
    private final DeezerClient deezerClient;
    private final CloudinaryService cloudinaryService;

    // Trae una pista de la Api de Deezer con el album
    @Transactional
    public ExtendedBaseResponse<TrackResponse> createDeezerTrack(TrackRequest request) {
        // Busca la pista en la base de datos
        Track track = trackRepository.findById(request.id()).orElseGet(() -> {

            // Si no lo encuentra, busca en la Api Deezer
            TrackDeezerResponse response = deezerClient.findTrackById(request.id());
            if(response.id() == null) {
                throw new EntityNotFoundException("Pista no encontrada para id: " + request.id());
            }

            // Sube la pista a cloudinary y su guarda url
            String previewUrl = cloudinaryService.uploadVideo(response.title(), response.id().toString(), response.preview());

            // Guarda pista y album en base de datos
            Track deezerTrack = albumTrackMapper.toTrack(response);
            deezerTrack.setPreviewUrl(previewUrl);
            if(!albumRepository.existsById(deezerTrack.getAlbum().getId()))
                albumRepository.save(deezerTrack.getAlbum());
            trackRepository.save(deezerTrack);

            return deezerTrack;
        });

        TrackResponse trackResponse = trackMapper.toTrackResponse(track);
        return ExtendedBaseResponse.of(BaseResponse.created("Pista creada."), trackResponse);
    }
}
