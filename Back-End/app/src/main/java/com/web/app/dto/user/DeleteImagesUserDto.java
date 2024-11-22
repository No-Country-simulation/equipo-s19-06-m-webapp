package com.web.app.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record DeleteImagesUserDto(

        @NotBlank(message = "La 'URL de la imagen' no puede estar vacía.")
        String url,
        @NotNull(message = "El 'ID del usuario' no puede estar vacío.")
        Long userId

) implements Serializable {
}
