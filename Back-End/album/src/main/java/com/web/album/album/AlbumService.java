package com.web.album.album;

import com.web.album.base.BaseResponse;
import com.web.album.base.ExtendedBaseResponse;
import com.web.album.deezer.DeezerClient;
import com.web.album.song.TracksDeezerResponse;
import com.web.album.song.TrackDeezerResponse;
import com.web.album.song.SongRequest;
import com.web.album.song.SongClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;
    private final SongClient songClient;
    private final DeezerClient deezerClient;

    public ExtendedBaseResponse<AlbumResponse> findAlbum(Long id) {
        Album album = albumRepository.findById(id).orElseThrow();
        AlbumResponse albumResponse = albumMapper.toAlbumResponse(album);
        return ExtendedBaseResponse.of(
                BaseResponse.ok("Album encontrado"),
                albumResponse
        );
    }

    public ExtendedBaseResponse<AlbumResponse> createDeezerAlbum(AlbumRequest request) {
        AlbumDeezerResponse albumDeezerResponse = deezerClient.findAlbumById(request.id());

        if(!albumRepository.existsById(request.id())) {
            Album newAlbum = albumMapper.toAlbum(albumDeezerResponse);
            albumRepository.save(newAlbum);
        }

        TracksDeezerResponse tracksDeezerResponse = albumDeezerResponse.tracks();
        for(TrackDeezerResponse response: tracksDeezerResponse.data()) {
            SongRequest songRequest = new SongRequest(response.id());
            songClient.createSong(songRequest);
        }

        AlbumResponse response = albumMapper.toAlbumResponse(albumDeezerResponse);

        return ExtendedBaseResponse.of(
                BaseResponse.created("Album creado"),
                response
        );
    }
}
