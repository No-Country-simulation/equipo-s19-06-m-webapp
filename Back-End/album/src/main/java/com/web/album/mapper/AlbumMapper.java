package com.web.album.mapper;

import com.web.album.dto.AlbumDeezerResponse;
import com.web.album.dto.AlbumResponse;
import com.web.album.dto.AlbumWithoutTracksResponse;
import com.web.album.model.Album;
import com.web.album.client.TrackClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumMapper {

    private final TrackMapper trackMapper;
    private final TrackClient trackClient;

    public com.web.album.model.Album toAlbum(AlbumDeezerResponse response){
        return Album.builder()
                .id(response.id())
                .name(response.title())
                .releaseDate(response.release_date())
                .pictureUrl(response.cover())
                .build();
    }

    public AlbumResponse toAlbumResponse(Album album) {
        return new AlbumResponse(
                album.getId(),
                album.getName(),
                album.getReleaseDate(),
//                album.getGenres(),
                album.getPictureUrl(),
                trackClient.findTracksByAlbumId(album.getId()).data()
        );
    }

    public AlbumWithoutTracksResponse toAlbumWithoutTracksResponse(Album album) {
        return new AlbumWithoutTracksResponse(
                album.getId(),
                album.getName(),
                album.getReleaseDate(),
//                album.getGenres(),
                album.getPictureUrl()
        );
    }

    public AlbumResponse toAlbumResponse(AlbumDeezerResponse albumDeezerResponse) {
        return new AlbumResponse(
                albumDeezerResponse.id(),
                albumDeezerResponse.title(),
                albumDeezerResponse.release_date(),
//                albumDeezerResponse.genres().data().stream().map(GenreDeezerResponse::name).toList(),
                albumDeezerResponse.cover(),
                albumDeezerResponse.tracks().data().stream().map(trackMapper::toTrackResponse).toList()
        );
    }
}
