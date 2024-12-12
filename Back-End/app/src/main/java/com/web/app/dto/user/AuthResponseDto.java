package com.web.app.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

public record AuthResponseDto(
        UserDto user,

        @Schema(description = "Token de autenticación JWT", example = "eyJhbGciOiJIUzUxMiJ9...")
        String token
) implements Serializable {
}


