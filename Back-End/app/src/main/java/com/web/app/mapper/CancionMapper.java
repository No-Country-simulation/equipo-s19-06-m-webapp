package com.web.app.mapper;

import com.web.app.dto.CancionAPIResponse;
import com.web.app.model.Cancion;
import org.springframework.stereotype.Service;

@Service
public class CancionMapper {

    public Cancion toCancion(CancionAPIResponse response){
        return Cancion.builder()
                .id(response.id())
                .nombre(response.title())
                .duracion(response.duration())
                .build();
    }
}
