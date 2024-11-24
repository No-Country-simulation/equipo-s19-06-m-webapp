package com.web.song.song;

import jakarta.validation.constraints.NotNull;

public record SongRequest(
        @NotNull(message = "El 'ID de la cancion' no puede estar vacío.")
        Long id
) {
}
