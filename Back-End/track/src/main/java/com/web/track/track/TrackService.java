package com.web.track.track;

import com.web.track.base.BaseResponse;
import com.web.track.base.ExtendedBaseResponse;
import com.web.track.deezer.DeezerClient;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackService {

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
