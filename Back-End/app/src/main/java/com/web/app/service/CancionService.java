package com.web.app.service;

import com.web.app.dto.CancionAPIResponse;
import com.web.app.mapper.CancionMapper;
import com.web.app.model.Cancion;
import com.web.app.repository.CancionRepository;
import com.web.app.dto.CancionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CancionService {

    private final CancionRepository repository;
    private final CancionMapper mapper;
    private final DeezerApiClient deezerApiClient;

    public void anadirCancion(CancionRequest request) {
        if(!repository.existsById(request.id())) {
            CancionAPIResponse cancionApi = deezerApiClient.buscarCancion(request.id());
            Cancion cancion = mapper.toCancion(cancionApi);
            repository.save(cancion);
        }
    }
}
