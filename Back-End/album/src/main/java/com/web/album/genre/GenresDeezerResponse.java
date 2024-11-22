package com.web.album.genre;

import java.util.List;

public record GenresDeezerResponse (
        List<GenreDeezerResponse> data
) {
}