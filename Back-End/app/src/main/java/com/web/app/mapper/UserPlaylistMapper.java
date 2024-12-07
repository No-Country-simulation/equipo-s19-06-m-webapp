package com.web.app.mapper;

import com.web.app.dto.user.UserPlaylistDto;
import com.web.app.model.UserPlaylist;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserPlaylistMapper {

    UserPlaylistDto toDto(UserPlaylist userPlaylist);
}
