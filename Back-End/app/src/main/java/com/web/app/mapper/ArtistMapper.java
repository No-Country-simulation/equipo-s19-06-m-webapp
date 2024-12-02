package com.web.app.mapper;

import com.web.app.dto.deezer.artist.ArtistDeezerResponse;
import com.web.app.model.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ArtistMapper {

    @Mapping(target = "fanNum", source = "nb_fan")
    @Mapping(target = "pictureUrl", source = "picture")
    Artist toArtist(ArtistDeezerResponse artistDeezerResponse);
}
