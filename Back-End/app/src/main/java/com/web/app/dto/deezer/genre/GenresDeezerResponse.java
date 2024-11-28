package com.web.app.dto.deezer.genre;

import java.util.List;

public record GenresDeezerResponse (
        List<GenreDeezerResponse> data
) {
}