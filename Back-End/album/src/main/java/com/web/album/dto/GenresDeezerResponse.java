package com.web.album.dto;

import java.util.List;

public record GenresDeezerResponse (
        List<GenreDeezerResponse> data
) {
}