package com.web.app.service.impl;

import com.web.app.dto.deezer.album.AlbumDeezerResponse;
import com.web.app.dto.deezer.genre.GenreDeezerResponse;
import com.web.app.mapper.GenreMapper;
import com.web.app.model.Album;
import com.web.app.model.Genre;
import com.web.app.repository.GenreRepository;
import com.web.app.service.api.DeezerClient;
import com.web.app.dto.BaseResponse;
import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.deezer.track.TrackDeezerResponse;
import com.web.app.dto.track.TrackRequest;
import com.web.app.dto.track.TrackResponse;
import com.web.app.mapper.AlbumTrackMapper;
import com.web.app.mapper.TrackMapper;
import com.web.app.model.Track;
import com.web.app.repository.AlbumRepository;
import com.web.app.repository.TrackRepository;
import com.web.app.service.TrackService;
import com.web.app.service.api.CloudinaryService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;
    private final AlbumRepository albumRepository;
    private final GenreMapper genreMapper;
    private final AlbumTrackMapper albumTrackMapper;
    private final TrackMapper trackMapper;
    private final DeezerClient deezerClient;
    private final CloudinaryService cloudinaryService;

    // Trae una pista de la Api de Deezer con el album
    @Transactional
    public ExtendedBaseResponse<TrackResponse> createDeezerTrack(TrackRequest request) {
        // Busca la pista en la base de datos
        Track track = trackRepository.findById(request.id()).orElseGet(() -> {

            // Si no lo encuentra, busca en la Api Deezer
            TrackDeezerResponse response = deezerClient.findTrackById(request.id());
            if(response.id() == null) {
                throw new EntityNotFoundException("Pista no encontrada para id: " + request.id());
            }

            // Sube la pista a cloudinary y guarda su url
            String previewUrl = cloudinaryService.uploadVideo(response.title(), response.id().toString(), response.preview());

            // Busca el album con los generos de la pista en la base de datos
            long albumId = response.album().id();
            Album album = albumRepository.findById(albumId).orElseGet(() -> {

                // Si no lo encuentra, busca en la Api Deezer
                AlbumDeezerResponse albumDeezerResponse = deezerClient.findAlbumById(albumId);

                // Crea el album con los generos
                Album deezerAlbum = albumTrackMapper.toAlbum(albumDeezerResponse);
                List<Genre> deezerGenres = albumDeezerResponse.genres().data()
                        .stream().map(deezerGenre -> {
                            Genre genre = genreMapper.toGenre(deezerGenre);
                            genre.setAlbum(deezerAlbum);
                            return genre;
                        }).toList();
                deezerAlbum.setGenres(deezerGenres);

                return deezerAlbum;
            });

            // Crea la pista y lo asocia a album
            Track deezerTrack = albumTrackMapper.toTrack(response);
            deezerTrack.setPreviewUrl(previewUrl);
            deezerTrack.setAlbum(album);
            if(album.getTracks() == null)
                album.setTracks(new ArrayList<>());
            album.getTracks().add(deezerTrack);

            // Guarda la pista, el album y los generos
            albumRepository.save(album);

            return deezerTrack;
        });

        TrackResponse trackResponse = trackMapper.toTrackResponse(track);
        return ExtendedBaseResponse.of(BaseResponse.created("Pista creada."), trackResponse);
    }
}
