package com.web.song.song;

import com.web.song.base.BaseResponse;
import com.web.song.base.ExtendedBaseResponse;
import com.web.song.deezer.DeezerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;
    private final SongMapper songMapper;
    private final DeezerClient deezerClient;

    public ExtendedBaseResponse<SongResponse> createDeezerSong(SongRequest request) {
        TrackDeezerResponse response = deezerClient.findSongById(request.id());

        if(!songRepository.existsById(request.id())) {
            Song song = songMapper.toSong(response);
            songRepository.save(song);
        }

        SongResponse songResponse = songMapper.toSongResponse(response);
        return ExtendedBaseResponse.of(BaseResponse.created("Cancion creada"), songResponse);
    }
}
