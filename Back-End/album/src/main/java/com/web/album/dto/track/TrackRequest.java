package com.web.album.dto.track;

import jakarta.validation.constraints.NotNull;

public record TrackRequest(
        @NotNull(message = "El 'ID del album' no puede estar vacío.")
        Long id
) {
}
