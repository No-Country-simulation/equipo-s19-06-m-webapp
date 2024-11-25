package com.web.track.dto.album;

import jakarta.validation.constraints.NotNull;

public record AlbumRequest(
        @NotNull(message = "El 'ID del album' no puede estar vacío.")
        Long id
) {
}
