package com.web.song.song;

import com.web.song.album.AlbumClient;
import com.web.song.song.CancionAPIResponse;
import com.web.song.song.CancionRequest;
import com.web.song.song.CancionMapper;
import com.web.song.song.Cancion;
import com.web.song.song.CancionRepository;
import com.web.song.deezer.DeezerApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CancionService {

    private final CancionRepository cancionRepository;
    private final CancionMapper cancionMapper;
    private final AlbumClient albumClient;
    private final DeezerApiClient deezerApiClient;

    public void anadirCancion(CancionRequest request) {
        if(!cancionRepository.existsById(request.id())) {
            CancionAPIResponse cancionApi = deezerApiClient.buscarCancion(request.id());
//            AlbumAPIResponse albumApi = cancionApi.album();
//
//            Album album = albumRepository.findById(albumApi.id()).orElse(
//                    albumMapper.toAlbum(albumApi));
//            albumRepository.save(album);

            Cancion cancion = cancionMapper.toCancion(cancionApi);
            cancionRepository.save(cancion);
        }
    }
}
