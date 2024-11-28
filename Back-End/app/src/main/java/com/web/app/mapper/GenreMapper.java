package com.web.app.mapper;

import com.web.app.dto.deezer.genre.GenreDeezerResponse;
import com.web.app.model.Genre;
import org.springframework.stereotype.Service;

@Service
public class GenreMapper {
    public Genre toGenre(GenreDeezerResponse response) {
        return Genre.builder()
                .name(response.name())
                .build();
    }
}
