package com.web.app.mapper;

import com.web.app.dto.album.AlbumResponse;
import com.web.app.dto.album.ShortAlbumResponse;
import com.web.app.dto.deezer.album.AlbumDeezerResponse;
import com.web.app.dto.deezer.album.ShortAlbumDeezerResponse;
import com.web.app.model.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {GenreMapper.class, TrackMapper.class, ArtistMapper.class},
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface AlbumMapper {

    ShortAlbumResponse toShortAlbumResponse(Album album);

    AlbumResponse toAlbumResponse(Album album);

    @Mapping(target = "name", source = "title")
    @Mapping(target = "pictureUrl", source = "cover")
    @Mapping(target = "releaseDate", source = "release_date", dateFormat = "yyyy-MM-dd")
    Album toAlbum(ShortAlbumDeezerResponse response);

    ShortAlbumDeezerResponse toShortAlbumDeezerResponse(AlbumDeezerResponse response);
}
