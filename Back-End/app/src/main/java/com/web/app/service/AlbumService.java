package com.web.app.service;

import com.web.app.dto.AlbumAPIResponse;
import com.web.app.dto.AlbumRequest;
import com.web.app.dto.CancionAPIResponse;
import com.web.app.dto.Tracks;
import com.web.app.mapper.AlbumMapper;
import com.web.app.mapper.CancionMapper;
import com.web.app.model.Album;
import com.web.app.model.Cancion;
import com.web.app.repository.AlbumRepository;
import com.web.app.repository.CancionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final CancionRepository cancionRepository;
    private final AlbumMapper albumMapper;
    private final CancionMapper cancionMapper;
    private final DeezerApiClient deezerApiClient;


    public void anadirAlbum(AlbumRequest request) {
        AlbumAPIResponse albumApi = deezerApiClient.buscarAlbumn(request.id());

        Album album = albumRepository.findById(request.id()).orElse(
                albumMapper.toAlbum(albumApi));
        albumRepository.save(album);

        Tracks tracks = albumApi.tracks();
        for(CancionAPIResponse cancionApi: tracks.data()) {
            Cancion cancion = cancionMapper.toCancion(cancionApi);
            cancionRepository.save(cancion);
        }

//        if(!albumRepository.existsById(request.id())) {
//            CancionAPIResponse cancionApi = deezerApiClient.buscarCancion(request.id());
//            AlbumAPIResponse albumApi = cancionApi.album();
//
//            Album album = albumRepository.findById(albumApi.id()).orElse(
//                    albumMapper.toAlbum(albumApi));
//            albumRepository.save(album);
//
//            Cancion cancion = cancionMapper.toCancion(cancionApi);
//            cancionRepository.save(cancion);
//        }
    }
}
