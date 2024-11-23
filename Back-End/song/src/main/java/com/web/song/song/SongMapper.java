package com.web.song.song;

import com.web.song.album.AlbumClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongMapper {

    private final AlbumClient albumClient;

    public Song toSong(TrackDeezerResponse response){
        return Song.builder()
                .id(response.id())
                .name(response.title())
                .duration(response.duration())
                .albumId(response.album().id())
                .urlPreview(response.preview())
                .build();
    }

    public SongResponse toSongResponse(Song song) {
        return new SongResponse(
                song.getId(),
                song.getName(),
                song.getDuration(),
                song.getUrlPreview(),
null
//                albumClient.findAlbum(song.getAlbumId()).data()
        );
    }
}
