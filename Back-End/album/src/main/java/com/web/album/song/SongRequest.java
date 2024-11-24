package com.web.album.song;

import jakarta.validation.constraints.NotNull;

public record SongRequest(
        @NotNull(message = "El 'ID del album' no puede estar vacío.")
        Long id
) {
}
