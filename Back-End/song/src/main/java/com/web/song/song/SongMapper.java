package com.web.song.song;

import com.web.song.album.AlbumMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongMapper {

    private final AlbumMapper albumMapper;

    public Song toSong(TrackDeezerResponse response){
        return Song.builder()
                .id(response.id())
                .name(response.title())
                .duration(response.duration())
                .albumId(response.album().id())
                .urlPreview(response.preview())
                .build();
    }

    public SongResponse toSongResponse(TrackDeezerResponse response) {
        return new SongResponse(
                response.id(),
                response.title(),
                response.duration(),
                response.preview(),
                albumMapper.toAlbumResponse(response.album())
        );
    }
}
