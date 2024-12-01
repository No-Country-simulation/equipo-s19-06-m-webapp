package com.web.app.mapper;

import com.web.app.dto.deezer.genre.GenreDeezerResponse;
import com.web.app.dto.deezer.genre.GenresDeezerResponse;
import com.web.app.model.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenreMapper {
    public Genre toGenre(GenreDeezerResponse response);

    public List<String> toStrings(List<Genre> genres);

    default public String toString (Genre genre) {
        return genre.getName();
    };

    public List<Genre> toGenres(List<GenreDeezerResponse> genreDeezerResponse);

    default public List<GenreDeezerResponse> toGenreDeezerResponses(GenresDeezerResponse genres) {
        if(genres == null)
            return null;
        return genres.data();
    }
}
