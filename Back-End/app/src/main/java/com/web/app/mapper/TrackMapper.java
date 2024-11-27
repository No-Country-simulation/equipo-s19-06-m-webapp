package com.web.app.mapper;

import com.web.app.dto.track.TrackResponse;
import com.web.app.model.Track;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrackMapper {
    private final AlbumMapper albumMapper;

    public TrackResponse toTrackResponse(Track track) {
        return new TrackResponse(
                track.getId(),
                track.getName(),
                track.getDuration(),
                track.getPreviewUrl(),
                albumMapper.toAlbumWithoutTracksResponse(track.getAlbum())
        );
    }
}
