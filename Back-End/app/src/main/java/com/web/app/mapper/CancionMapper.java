package com.web.app.mapper;

import com.web.app.dto.CancionAPIResponse;
import com.web.app.model.Cancion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CancionMapper {
    private final AlbumMapper albumMapper;

    public Cancion toCancion(CancionAPIResponse response){
        return Cancion.builder()
                .id(response.id())
                .nombre(response.title())
                .duracion(response.duration())
                .album(albumMapper.toAlbum(response.album()))
                .build();
    }
}
