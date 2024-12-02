package com.web.app.dto.user;

import com.web.app.model.Role;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

public record UserDto(
        @Schema(description = "ID único del usuario", example = "1")
        Long id,
        @Schema(description = "Nombre de usuario", example = "LucianoEM")
        String username,
        @Schema(description = "Correo electrónico del usuario", example = "lucianomolina970@gmail.com")
        String email,
        @Schema(description = "Número de contacto del usuario", example = "351-2543548")
        String contact,
        @Schema(description = "Imagen de perfil del usuario", example = "https://example.com/profile.jpg")
        String userImage,
        @Schema(description = "Rol del usuario", example = "USER")
        Role role,
        @Schema(description = "Estado del usuario", example = "true")
        Boolean isActive

) implements Serializable {
}
