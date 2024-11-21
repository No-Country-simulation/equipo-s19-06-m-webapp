package com.web.song.song;

import com.web.song.song.CancionAPIResponse;
import com.web.song.song.Cancion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CancionMapper {
//    private final AlbumMapper albumMapper;

    public Cancion toCancion(CancionAPIResponse response){
        return Cancion.builder()
                .id(response.id())
                .nombre(response.title())
                .duracion(response.duration())
//                .album(albumMapper.toAlbum(response.album()))
                .url(response.preview())
                .build();
    }
}
