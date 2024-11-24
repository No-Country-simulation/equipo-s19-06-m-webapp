package com.web.track.service.impl;

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
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;
    private final TrackMapper trackMapper;
    private final DeezerClient deezerClient;

    public ExtendedBaseResponse<List<TrackResponse>> findTracksByAlbumId(Long albumId) {
        List<TrackResponse> trackRespons = trackRepository.findAllByAlbumId(albumId)
                .stream()
                .map(trackMapper::toTrackResponse)
                .toList();
        return ExtendedBaseResponse.of(BaseResponse.ok("Canciones encontradas."), trackRespons);
    }

    public ExtendedBaseResponse<TrackResponse> createDeezerTrack(TrackRequest request) {
        Track track = trackRepository.findById(request.id()).orElseGet(() -> {
            TrackDeezerResponse response = deezerClient.findTrackById(request.id());

            if(response.id() == null) {
                throw new EntityNotFoundException("Cancion no encontrada.");
            }

            Track deezerTrack = trackMapper.toTrack(response);
            trackRepository.save(deezerTrack);
            return deezerTrack;
        });

        TrackResponse trackResponse = trackMapper.toTrackResponse(track);
        return ExtendedBaseResponse.of(BaseResponse.created("Cancion creada."), trackResponse);
    }
}
