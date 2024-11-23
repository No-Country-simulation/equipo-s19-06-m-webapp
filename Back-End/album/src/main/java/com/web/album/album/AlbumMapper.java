package com.web.album.album;

import com.web.album.genre.GenreDeezerResponse;
import com.web.album.song.SongClient;
import com.web.album.song.SongMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumMapper {

    private final SongMapper songMapper;
    private final SongClient songClient;

    public Album toAlbum(AlbumDeezerResponse response){
        return Album.builder()
                .id(response.id())
                .name(response.title())
                .releaseDate(response.release_date())
                .urlImg(response.cover())
                .build();
    }

    public AlbumResponse toAlbumResponse(Album album) {
        return new AlbumResponse(
                album.getId(),
                album.getName(),
                album.getReleaseDate(),
//                album.getGenres(),
                album.getUrlImg(),
                songClient.findSongsByAlbumId(album.getId()).data()
        );
    }

    public AlbumWithoutTracksResponse toAlbumWithoutTracksResponse(Album album) {
        return new AlbumWithoutTracksResponse(
                album.getId(),
                album.getName(),
                album.getReleaseDate(),
//                album.getGenres(),
                album.getUrlImg()
        );
    }

    public AlbumResponse toAlbumResponse(AlbumDeezerResponse albumDeezerResponse) {
        return new AlbumResponse(
                albumDeezerResponse.id(),
                albumDeezerResponse.title(),
                albumDeezerResponse.release_date(),
//                albumDeezerResponse.genres().data().stream().map(GenreDeezerResponse::name).toList(),
                albumDeezerResponse.cover(),
                albumDeezerResponse.tracks().data().stream().map(songMapper::toSongResponse).toList()
        );
    }
}
