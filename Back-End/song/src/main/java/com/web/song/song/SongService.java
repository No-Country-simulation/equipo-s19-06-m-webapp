package com.web.song.song;

import com.web.song.deezer.DeezerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;
    private final SongMapper songMapper;
    private final DeezerClient deezerClient;

    public void createSong(SongRequest request) {
        if(!songRepository.existsById(request.id())) {
            SongDeezerResponse response = deezerClient.findSongById(request.id());
            Song song = songMapper.toSong(response);
            songRepository.save(song);
        }
    }
}
