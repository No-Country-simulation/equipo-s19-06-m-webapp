package com.web.app.mapper;

import com.web.app.dto.album.AlbumResponse;
import com.web.app.dto.album.AlbumSummaryResponse;
import com.web.app.dto.deezer.album.AlbumDeezerResponse;
import com.web.app.dto.deezer.album.AlbumDeezerSummaryResponse;
import com.web.app.model.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {GenreMapper.class, TrackMapper.class, ArtistMapper.class},
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface AlbumMapper {

    AlbumResponse toAlbumResponse(Album album);

    @Mapping(target = "name", source = "title")
    @Mapping(target = "pictureUrl", source = "cover")
    @Mapping(target = "releaseDate", source = "release_date", dateFormat = "yyyy-MM-dd")
    Album toAlbum(AlbumDeezerSummaryResponse response);

    AlbumDeezerSummaryResponse toAlbumDeezerSummaryResponse(AlbumDeezerResponse response);
}
