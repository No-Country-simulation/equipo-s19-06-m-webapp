package com.web.song.song;

import com.web.song.album.AlbumClient;
import com.web.song.album.AlbumResponse;
import com.web.song.base.BaseResponse;
import com.web.song.base.ExtendedBaseResponse;
import com.web.song.deezer.DeezerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;
    private final SongMapper songMapper;
    private final DeezerClient deezerClient;
    private final AlbumClient albumClient;

    public ExtendedBaseResponse<List<SongResponse>> findSongsByAlbumId(Long albumId) {
        List<SongResponse> songResponses = songRepository.findAllByAlbumId(albumId)
                .stream()
                .map(songMapper::toSongResponse)
                .toList();
        return ExtendedBaseResponse.of(BaseResponse.ok("Canciones encontradas"), songResponses);
    }

    public ExtendedBaseResponse<SongResponse> createDeezerSong(SongRequest request) {
        Song song = songRepository.findById(request.id()).orElseGet(() -> {
            TrackDeezerResponse response = deezerClient.findSongById(request.id());
            Song deezerSong = songMapper.toSong(response);
            songRepository.save(deezerSong);
            return deezerSong;
        });

        SongResponse songResponse = songMapper.toSongResponse(song);
        return ExtendedBaseResponse.of(BaseResponse.created("Cancion creada"), songResponse);
    }
}
