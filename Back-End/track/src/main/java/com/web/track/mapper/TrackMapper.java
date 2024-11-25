package com.web.track.mapper;

import com.web.track.client.AlbumClient;
import com.web.track.model.Track;
import com.web.track.dto.deezer.TrackDeezerResponse;
import com.web.track.dto.track.TrackResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrackMapper {

    private final AlbumClient albumClient;

    public Track toTrack(TrackDeezerResponse response){
        return Track.builder()
                .id(response.id())
                .name(response.title())
                .duration(response.duration())
                .albumId(response.album().id())
                .previewUrl(response.preview())
                .build();
    }

    public TrackResponse toTrackResponse(Track track) {
        return new TrackResponse(
                track.getId(),
                track.getName(),
                track.getDuration(),
                track.getPreviewUrl(),
                albumClient.findAlbum(track.getAlbumId()).data()
        );
    }
}
