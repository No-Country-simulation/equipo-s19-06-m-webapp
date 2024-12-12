package com.web.app.mapper;

import com.web.app.dto.user.AuthResponseDto;
import com.web.app.dto.user.UpdatedUserDto;
import com.web.app.dto.user.UserDto;
import com.web.app.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User toEntity(UserDto userDto);

    @Mapping(target = "username", expression = "java(mapUsername(user))")
    UserDto toDto(User user);

    List<UserDto> entityListToDtoList(List<User> users);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(target = "username", expression = "java(mapUsername(user))")
    UpdatedUserDto toUpdatedUser(User user);

    @Mapping(source = "user.id", target = "id")
    @Mapping(target = "username", expression = "java(mapUsername(user))")
    @Mapping(target = "token", ignore = true)
    AuthResponseDto toAuthResponse(User user);

    default String mapUsername(User user) {
        return user.getName();
    }

}
