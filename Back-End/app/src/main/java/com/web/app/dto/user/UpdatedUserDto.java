package com.web.app.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

public record UpdatedUserDto(
        @Schema(description = "ID único del usuario", example = "1")
        Long userId,
        @Schema(description = "Nombre de usuario", example = "LucianoMO")
        String username,
        @Schema(description = "Correo electrónico del usuario", example = "lucianoFront23@gmail.com")
        String email,
        @Schema(description = "Contraseña del usuario", example = "123456789Back* (Encriptado)")
        String password
) implements Serializable {
}
