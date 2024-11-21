package com.web.app.mapper;

import com.web.app.dto.AlbumAPIResponse;
import com.web.app.model.Album;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class AlbumMapper {

    public Album toAlbum(AlbumAPIResponse response) {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return Album.builder()
                .id(response.id())
                .nombre(response.title())
                .fechaLanzamiento(LocalDate.parse(response.release_date(), dtf))
                .build();
    }
}
