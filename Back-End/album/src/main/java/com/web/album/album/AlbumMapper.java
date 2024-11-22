package com.web.album.album;

import com.web.album.genre.GenreDeezerResponse;
import com.web.album.song.SongMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumMapper {

    private final SongMapper songMapper;

    public Album toAlbum(AlbumDeezerResponse response){
        return Album.builder()
                .id(response.id())
                .name(response.title())
                .releaseDate(response.release_date())
                .urlImg(response.cover())
                .build();
    }

    public AlbumResponse toAlbumResponse(AlbumDeezerResponse albumDeezerResponse) {
        return new AlbumResponse(
                albumDeezerResponse.id(),
                albumDeezerResponse.title(),
                albumDeezerResponse.release_date(),
                albumDeezerResponse.genres().data().stream().map(GenreDeezerResponse::name).toList(),
                albumDeezerResponse.cover(),
                albumDeezerResponse.tracks().data().stream().map(songMapper::toSongResponse).toList()
        );
    }
}
