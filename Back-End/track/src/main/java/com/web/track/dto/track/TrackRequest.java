package com.web.track.dto.track;

import jakarta.validation.constraints.NotNull;

public record TrackRequest(
        @NotNull(message = "El 'ID de la cancion' no puede estar vacío.")
        Long id
) {
}
