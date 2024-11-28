package com.web.app.mapper;

import com.web.app.dto.album.AlbumResponse;
import com.web.app.dto.deezer.album.AlbumDeezerResponse;
import com.web.app.dto.deezer.album.AlbumDeezerWithoutTracksResponse;
import com.web.app.dto.deezer.track.TrackDeezerResponse;
import com.web.app.model.Album;
import com.web.app.model.Genre;
import com.web.app.model.Track;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumTrackMapper {

    private final TrackMapper trackMapper;
    private final GenreMapper genreMapper;

    public AlbumResponse toAlbumResponse(Album album) {
        return new AlbumResponse(
                album.getId(),
                album.getName(),
                album.getReleaseDate(),
                album.getGenres().stream().map(Genre::getName).toList(),
                album.getPictureUrl(),
                album.getTracks().stream().map(trackMapper::toShortTrackResponse).toList()
        );
    }

    public Album toAlbum(AlbumDeezerResponse response){
        return Album.builder()
                .id(response.id())
                .name(response.title())
                .releaseDate(response.release_date())
                .pictureUrl(response.cover())
                .build();
    }

    public Track toTrack(TrackDeezerResponse response){
        return Track.builder()
                .id(response.id())
                .name(response.title())
                .duration(response.duration())
                .build();
    }
}
