package com.web.app.dto.user;

import com.web.app.model.Role;

import java.io.Serializable;

public record UserDto(
    Long id,
    String username,
    String email,
    String contact,
    String userImage,
    Role role,
    Boolean isActive
) implements Serializable {
}
