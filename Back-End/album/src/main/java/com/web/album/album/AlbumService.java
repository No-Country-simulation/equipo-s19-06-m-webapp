package com.web.album.album;

import com.web.album.deezer.DeezerApiClient;
import com.web.album.song.SongClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;
    private final SongClient songClient;
    private final DeezerApiClient deezerApiClient;

    public void anadirAlbum(AlbumRequest request) {
        AlbumAPIResponse albumApi = deezerApiClient.buscarAlbumn(request.id());

        Album album = albumRepository.findById(request.id()).orElse(
                albumMapper.toAlbum(albumApi));
        albumRepository.save(album);

//        Tracks tracks = albumApi.tracks();
//        for(CancionAPIResponse cancionApi: tracks.data()) {
//            Cancion cancion = cancionMapper.toCancion(cancionApi);
//            cancionRepository.save(cancion);
//        }

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
