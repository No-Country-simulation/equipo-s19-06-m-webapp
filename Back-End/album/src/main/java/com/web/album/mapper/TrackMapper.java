package com.web.album.mapper;

import com.web.album.dto.TrackDeezerResponse;
import com.web.album.dto.TrackResponse;
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
