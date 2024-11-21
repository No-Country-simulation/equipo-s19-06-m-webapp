package com.web.app.service;

import com.web.app.dto.AlbumAPIResponse;
import com.web.app.dto.CancionAPIResponse;
import com.web.app.mapper.AlbumMapper;
import com.web.app.mapper.CancionMapper;
import com.web.app.model.Album;
import com.web.app.model.Cancion;
import com.web.app.repository.AlbumRepository;
import com.web.app.repository.CancionRepository;
import com.web.app.dto.CancionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CancionService {

    private final CancionRepository cancionRepository;
    private final AlbumRepository albumRepository;
    private final CancionMapper cancionMapper;
    private final AlbumMapper albumMapper;
    private final DeezerApiClient deezerApiClient;

    public void anadirCancion(CancionRequest request) {
        if(!cancionRepository.existsById(request.id())) {
            CancionAPIResponse cancionApi = deezerApiClient.buscarCancion(request.id());
            AlbumAPIResponse albumApi = cancionApi.album();

            Album album = albumRepository.findById(albumApi.id()).orElse(
                    albumMapper.toAlbum(albumApi));
            albumRepository.save(album);

            Cancion cancion = cancionMapper.toCancion(cancionApi);
            cancionRepository.save(cancion);
        }
    }
}
