package com.web.app.service.impl;

import com.web.app.dto.BaseResponse;
import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.user.CreateUserPlaylistDto;
import com.web.app.dto.user.UpdateUserPlaylistDto;
import com.web.app.dto.user.UserPlaylistDto;
import com.web.app.exception.userExc.UserNotFoundException;
import com.web.app.mapper.UserPlaylistMapper;
import com.web.app.model.Playlist;
import com.web.app.model.User;
import com.web.app.model.UserPlaylist;
import com.web.app.repository.PlaylistRepository;
import com.web.app.repository.UserPlaylistRepository;
import com.web.app.repository.UserRepository;
import com.web.app.service.UserPlaylistService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserPlaylistServiceImpl implements UserPlaylistService {

    private final UserPlaylistRepository userPlaylistRepository;
    private final UserRepository userRepository;
    private final PlaylistRepository playlistRepository;
    private final UserPlaylistMapper userPlaylistMapper;


    @Override
    @Transactional
    public ExtendedBaseResponse<UserPlaylistDto> createUserPlaylist(CreateUserPlaylistDto dto) {


        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + dto.getUserId()));


        Playlist playlist = playlistRepository.findById(dto.getPlaylistId())
                .orElseThrow(() -> new RuntimeException("Playlist not found with ID: " + dto.getPlaylistId()));


        UserPlaylist userPlaylist = new UserPlaylist();
        userPlaylist.setUser(user);
        userPlaylist.setPlaylist(playlist);
        userPlaylist.setCreatedAt(LocalDateTime.now());


        UserPlaylist savedUserPlaylist = userPlaylistRepository.save(userPlaylist);


        UserPlaylistDto userPlaylistDto = userPlaylistMapper.toDto(savedUserPlaylist);


        return ExtendedBaseResponse.of(BaseResponse.created("User Playlist created successfully"), userPlaylistDto);
    }


    @Override
    @Transactional
    public ExtendedBaseResponse<UserPlaylistDto> updateUserPlaylist(UpdateUserPlaylistDto dto) {
        UserPlaylist userPlaylist = userPlaylistRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("UserPlaylist not found with ID: " + dto.getId()));


        Playlist playlist = playlistRepository.findById(dto.getPlaylistId())
                .orElseThrow(() -> new RuntimeException("Playlist not found with ID: " + dto.getPlaylistId()));
        userPlaylist.setPlaylist(playlist);
        userPlaylist.setUpdatedAt(LocalDateTime.now());


        UserPlaylist updatedUserPlaylist = userPlaylistRepository.save(userPlaylist);


        UserPlaylistDto userPlaylistDto = userPlaylistMapper.toDto(updatedUserPlaylist);
        return ExtendedBaseResponse.of(BaseResponse.ok("User Playlist updated successfully"), userPlaylistDto);
    }


    @Override
    @Transactional
    public ExtendedBaseResponse<String> deleteUserPlaylist(Long id) {
        UserPlaylist userPlaylist = userPlaylistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserPlaylist not found with ID: " + id));

        userPlaylistRepository.delete(userPlaylist);

        return ExtendedBaseResponse.of(BaseResponse.ok("User Playlist deleted successfully"), "Deleted");
    }
    @Override
    @Transactional(readOnly = true)
    public ExtendedBaseResponse<List<UserPlaylistDto>> getAllUserPlaylists() {
        List<UserPlaylist> userPlaylists = userPlaylistRepository.findAll();

        List<UserPlaylistDto> userPlaylistDtos = userPlaylists.stream()
                .map(userPlaylistMapper::toDto)
                .collect(Collectors.toList());

        return ExtendedBaseResponse.of(BaseResponse.ok("All User Playlists retrieved successfully"), userPlaylistDtos);
    }

    @Override
    @Transactional(readOnly = true)
    public ExtendedBaseResponse<UserPlaylistDto> getUserPlaylistById(Long id) {
        UserPlaylist userPlaylist = userPlaylistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserPlaylist not found with ID: " + id));

        UserPlaylistDto userPlaylistDto = userPlaylistMapper.toDto(userPlaylist);
        return ExtendedBaseResponse.of(BaseResponse.ok("User Playlist retrieved successfully"), userPlaylistDto);
    }
}
