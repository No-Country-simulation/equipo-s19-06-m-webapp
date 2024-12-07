package com.web.app.mapper;

import com.web.app.dto.deezer.track.TrackDeezerResponse;
import com.web.app.dto.deezer.track.TracksDeezerResponse;
import com.web.app.dto.track.TrackSummaryResponse;
import com.web.app.dto.track.TrackResponse;
import com.web.app.model.Track;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = GenreMapper.class,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface TrackMapper {

    @Mapping(target = "artist", source = "album.artist")
    @Mapping(target = "title", source = "name")
    @Mapping(target = "preview", source = "previewUrl")
    @Mapping(target = "album.picture_url", source = "album.pictureUrl")
    @Mapping(target = "album.artist", ignore = true)
    @Mapping(target = "album.genre", expression = "java(genre)")
    TrackResponse toTrackResponse(Track track, @Context String genre) ;

    TrackSummaryResponse toTrackSummaryResponse(Track track);

    @Mapping(target = "name", source = "title")
    Track toTrack(TrackDeezerResponse response);

    List<Track> toTracks(List<TrackDeezerResponse> trackDeezerResponses);

    default List<TrackDeezerResponse> toTrackDeezerResponses(TracksDeezerResponse tracksDeezerResponse) {
        return tracksDeezerResponse.data();
    }
}
