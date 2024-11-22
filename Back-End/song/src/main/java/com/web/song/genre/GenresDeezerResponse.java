package com.web.song.genre;

import com.web.song.genre.GenreDeezerResponse;

import java.util.List;

public record GenresDeezerResponse (
        List<GenreDeezerResponse> data
) {
}