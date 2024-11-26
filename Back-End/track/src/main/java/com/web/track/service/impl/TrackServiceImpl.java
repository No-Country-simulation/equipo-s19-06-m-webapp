package com.web.track.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;
import com.cloudinary.utils.ObjectUtils;
import com.web.track.dto.BaseResponse;
import com.web.track.dto.ExtendedBaseResponse;
import com.web.track.client.DeezerClient;
import com.web.track.mapper.TrackMapper;
import com.web.track.model.Track;
import com.web.track.repository.TrackRepository;
import com.web.track.dto.deezer.TrackDeezerResponse;
import com.web.track.dto.track.TrackRequest;
import com.web.track.dto.track.TrackResponse;
import com.web.track.service.TrackService;
import com.web.track.service.api.CloudinaryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;
    private final TrackMapper trackMapper;
    private final DeezerClient deezerClient;
    private final CloudinaryService cloudinaryService;

    // Obtiene pistas de un album en la base de datos
    public ExtendedBaseResponse<List<TrackResponse>> findTracksByAlbumId(Long albumId) {
        List<TrackResponse> trackResponses = trackRepository.findAllByAlbumId(albumId)
                .stream()
                .map(trackMapper::toTrackResponse)
                .toList();
        return ExtendedBaseResponse.of(BaseResponse.ok("Canciones encontradas."), trackResponses);
    }

    // Trae una pista de la Api de Deezer si no ha traido ya
    public ExtendedBaseResponse<TrackResponse> createDeezerTrack(TrackRequest request) {
        // Busca la pista en la base de datos. Si no lo encuentra, busca en la Api Deezer
        Track track = trackRepository.findById(request.id()).orElseGet(() -> {
            TrackDeezerResponse response = deezerClient.findTrackById(request.id());
            if(response.id() == null) {
                throw new EntityNotFoundException("Cancion no encontrada.");
            }

            // Sube pista a cloudinary
            String previewUrl = cloudinaryService.uploadVideo(response.title(), response.id().toString(), response.preview());

            // Guarda informacion de pista en base de datos
            Track deezerTrack = trackMapper.toTrack(response, previewUrl);
            trackRepository.save(deezerTrack);

            return deezerTrack;
        });

        TrackResponse trackResponse = trackMapper.toTrackResponse(track);
        return ExtendedBaseResponse.of(BaseResponse.created("Cancion creada."), trackResponse);
    }
}
