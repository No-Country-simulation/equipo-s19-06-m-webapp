package com.web.album.album;

import com.web.album.deezer.DeezerApiClient;
import com.web.album.deezer.Tracks;
import com.web.album.song.CancionAPIResponse;
import com.web.album.song.CancionRequest;
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

    public void createAlbum(AlbumRequest request) {
        AlbumAPIResponse albumApi = deezerApiClient.buscarAlbumn(request.id());

        if(!albumRepository.existsById(request.id())) {
            Album newAlbum = albumMapper.toAlbum(albumApi);
            albumRepository.save(newAlbum);
        }

        Tracks tracks = albumApi.tracks();
        for(CancionAPIResponse cancionApi: tracks.data()) {
            CancionRequest cancionRequest = new CancionRequest(cancionApi.id());
            songClient.createSong(cancionRequest);
        }
    }
}
