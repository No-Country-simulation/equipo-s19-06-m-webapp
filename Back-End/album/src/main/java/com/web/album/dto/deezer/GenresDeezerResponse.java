package com.web.album.dto.deezer;

import java.util.List;

public record GenresDeezerResponse (
        List<GenreDeezerResponse> data
) {
}