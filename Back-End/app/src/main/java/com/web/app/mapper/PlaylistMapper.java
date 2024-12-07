package com.web.app.mapper;

import com.web.app.dto.playlist.CreatePlaylistDto;
import com.web.app.dto.playlist.PlaylistDto;
import com.web.app.dto.user.UserPlaylistDto;
import com.web.app.model.Playlist;
import com.web.app.model.UserPlaylist;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlaylistMapper {

    PlaylistDto toDto(Playlist playlist);

    CreatePlaylistDto toCreateDto(Playlist playlist);
}
