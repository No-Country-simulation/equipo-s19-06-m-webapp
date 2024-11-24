package com.web.album.track;

import org.springframework.stereotype.Service;

@Service
public class TrackMapper {

    public TrackResponse toTrackResponse(TrackDeezerResponse trackDeezerResponse) {
        return new TrackResponse(
                trackDeezerResponse.id(),
                trackDeezerResponse.title(),
                trackDeezerResponse.duration(),
                trackDeezerResponse.preview()
        );
    }
}
