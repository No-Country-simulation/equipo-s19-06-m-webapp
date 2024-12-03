package com.web.app.mapper;

import com.web.app.dto.deezer.track.TrackDeezerResponse;
import com.web.app.dto.deezer.track.TracksDeezerResponse;
import com.web.app.dto.track.TrackSummaryResponse;
import com.web.app.dto.track.TrackResponse;
import com.web.app.model.Track;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = GenreMapper.class,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface TrackMapper {
    TrackResponse toTrackResponse(Track track) ;

    TrackSummaryResponse toTrackSummaryResponse(Track track);

    @Mapping(target = "name", source = "title")
    Track toTrack(TrackDeezerResponse response);

    List<Track> toTracks(List<TrackDeezerResponse> trackDeezerResponses);

    default List<TrackDeezerResponse> toTrackDeezerResponses(TracksDeezerResponse tracksDeezerResponse) {
        return tracksDeezerResponse.data();
    }
}
