package com.web.app.service.impl;

import com.web.app.dto.deezer.album.AlbumDeezerResponse;
import com.web.app.dto.deezer.album.ShortAlbumDeezerResponse;
import com.web.app.dto.deezer.artist.ArtistDeezerResponse;
import com.web.app.exception.albumExc.AlbumNotFoundException;
import com.web.app.exception.artistExc.ArtistNotFoundException;
import com.web.app.exception.trackExc.TrackNotFoundException;
import com.web.app.mapper.AlbumMapper;
import com.web.app.mapper.ArtistMapper;
import com.web.app.mapper.GenreMapper;
import com.web.app.model.Album;
import com.web.app.model.Artist;
import com.web.app.model.Genre;
import com.web.app.repository.ArtistRepository;
import com.web.app.service.api.DeezerClient;
import com.web.app.dto.BaseResponse;
import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.deezer.track.TrackDeezerResponse;
import com.web.app.dto.track.TrackResponse;
import com.web.app.mapper.TrackMapper;
import com.web.app.model.Track;
import com.web.app.repository.AlbumRepository;
import com.web.app.repository.TrackRepository;
import com.web.app.service.TrackService;
import com.web.app.service.api.CloudinaryService;
import com.web.app.util.UriUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final GenreMapper genreMapper;
    private final AlbumMapper albumMapper;
    private final TrackMapper trackMapper;
    private final ArtistMapper artistMapper;
    private final DeezerClient deezerClient;
    private final CloudinaryService cloudinaryService;
    private final UriUtil uriUtil;

    // Trae una pista con el artista y el album de la Api de Deezer
    @Transactional
    public ExtendedBaseResponse<URI> createDeezerTrack(long id) {
        // Mira si la pista esta creada en la base de datos
        if (!artistRepository.existsById(id)) {
            // Si no lo encuentra, busca en la Api Deezer
            TrackDeezerResponse response = deezerClient.findTrackById(id);
            if(response.id() == null) {
                throw new TrackNotFoundException("Pista no encontrada para id: " + id);
            }

            // Busca el artista con numeros de fans de la pista en la base de datos
            long artistId = response.artist().id();
            Artist artist = artistRepository.findById(artistId).orElseGet(() -> {

                // Si no lo encuentra, busca en la Api Deezer
                ArtistDeezerResponse artistDeezerResponse = deezerClient.findArtistById(artistId);
                if(artistDeezerResponse.id() == null)
                    throw new ArtistNotFoundException("Artista no encontrado para id: " + id);

                // Guarda artista
                Artist deezerArtist = artistMapper.toArtist(artistDeezerResponse);
                artistRepository.save(deezerArtist);

                return deezerArtist;
            });

            // Busca el album con los generos de la pista en la base de datos
            long albumId = response.album().id();
            Album album = albumRepository.findById(albumId).orElseGet(() -> {

                // Si no lo encuentra, busca en la Api Deezer
                AlbumDeezerResponse albumDeezerResponse = deezerClient.findAlbumById(albumId);
                if(albumDeezerResponse.id() == null)
                    throw new AlbumNotFoundException("Album no encontrado para id: " + id);
                // Quita cancionas de la respuesta con el album para no crear todos
                ShortAlbumDeezerResponse shortAlbumDeezerResponse = albumMapper.toShortAlbumDeezerResponse(albumDeezerResponse);

                // Crea el album con los generos
                Album deezerAlbum = albumMapper.toAlbum(shortAlbumDeezerResponse);
                List<Genre> deezerGenres = albumDeezerResponse.genres().data()
                        .stream().map(deezerGenre -> {
                            Genre genre = genreMapper.toGenre(deezerGenre);
                            genre.setAlbum(deezerAlbum);
                            return genre;
                        }).toList();
                deezerAlbum.setGenres(deezerGenres);
                deezerAlbum.setArtist(artist);
                albumRepository.save(deezerAlbum);

                return deezerAlbum;
            });

            // Sube la pista a cloudinary y guarda su url
            String previewUrl = cloudinaryService.uploadVideo(response.title(), response.id().toString(), response.preview());

            // Crea la pista y lo asocia a album
            Track deezerTrack = trackMapper.toTrack(response);
            deezerTrack.setPreviewUrl(previewUrl);
            deezerTrack.setAlbum(album);
            trackRepository.save(deezerTrack);
        }
        URI response = uriUtil.buildResourceUri("/tracks/" + id);

        return ExtendedBaseResponse.of(BaseResponse.created("Pista creada."), response);
    }

    @Override
    public ExtendedBaseResponse<TrackResponse> findTrack(long id) {
        Track track = trackRepository.findById(id)
                .orElseThrow(() -> new TrackNotFoundException("Pista no encontrado para id: " + id));

        TrackResponse response = trackMapper.toTrackResponse(track);
        return ExtendedBaseResponse.of(BaseResponse.ok("Pista encontrada"), response);
    }
}
