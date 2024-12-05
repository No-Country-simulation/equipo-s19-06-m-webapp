package com.web.app.service.impl;

import com.web.app.dto.BaseResponse;
import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.playlist.CreatePlaylistDto;
import com.web.app.dto.playlist.PlaylistDto;
import com.web.app.dto.playlist.UpdatePlaylistDto;
import com.web.app.exception.userExc.UserNotFoundException;
import com.web.app.mapper.PlaylistMapper;
import com.web.app.model.Playlist;
import com.web.app.model.User;
import com.web.app.repository.PlaylistRepository;
import com.web.app.repository.UserRepository;
import com.web.app.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final UserRepository userRepository;
    private final PlaylistMapper playlistMapper;


    @Override
    @Transactional
    public ExtendedBaseResponse<PlaylistDto> createPlaylist(CreatePlaylistDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + dto.getUserId()));

        Playlist playlist = Playlist.builder()
                .name(dto.getName())
                .user(user)
                .createdAt(LocalDateTime.now())
                .isPublic(dto.isPublic())
                .build();

        Playlist savedPlaylist = playlistRepository.save(playlist);

        PlaylistDto playlistDto = playlistMapper.toDto(savedPlaylist);
        return ExtendedBaseResponse.of(BaseResponse.created("Playlist created successfully"), playlistDto);
    }
    @Override
    public ExtendedBaseResponse<PlaylistDto> updatePlaylist(UpdatePlaylistDto dto) {
        Playlist playlist = playlistRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Playlist not found with ID: " + dto.getId()));

        playlist.setName(dto.getName());
        playlist.setUpdatedAt(LocalDateTime.now());

        Playlist updatedPlaylist = playlistRepository.save(playlist);

        PlaylistDto playlistDto = playlistMapper.toDto(updatedPlaylist);
        return ExtendedBaseResponse.of(BaseResponse.ok("Playlist updated successfully"), playlistDto);
    }

    @Override
    public ExtendedBaseResponse<String> deletePlaylist(Long id) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playlist not found with ID: " + id));

        playlistRepository.delete(playlist);

        return ExtendedBaseResponse.of(BaseResponse.ok("Playlist deleted successfully "),"Deleted");
    }

    @Override
    @Transactional(readOnly = true)
    public ExtendedBaseResponse<List<PlaylistDto>> getAllPlaylists() {
        List<Playlist> playlists = playlistRepository.findAll();

        List<PlaylistDto> playlistDtos = playlists.stream()
                .map(playlistMapper::toDto)
                .collect(Collectors.toList());

        return ExtendedBaseResponse.of(BaseResponse.ok("All Playlist returned "), playlistDtos);
     }

    @Override
    @Transactional(readOnly = true)
    public ExtendedBaseResponse<PlaylistDto> getPlaylistById(Long id) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playlist not found with ID: " + id));

            PlaylistDto playlistDto = playlistMapper.toDto(playlist);
            return ExtendedBaseResponse.of(BaseResponse.ok("Playlist retrieved successfully"), playlistDto);
    }
}
