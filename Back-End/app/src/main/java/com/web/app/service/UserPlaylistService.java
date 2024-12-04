package com.web.app.service;

import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.user.CreateUserPlaylistDto;
import com.web.app.dto.user.UpdateUserPlaylistDto;
import com.web.app.dto.user.UserPlaylistDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserPlaylistService {

    ExtendedBaseResponse<UserPlaylistDto> createUserPlaylist(CreateUserPlaylistDto dto);

    ExtendedBaseResponse<UserPlaylistDto> updateUserPlaylist(UpdateUserPlaylistDto dto);

    ExtendedBaseResponse<String> deleteUserPlaylist(Long id);


    ExtendedBaseResponse<List<UserPlaylistDto>> getAllUserPlaylists();

    ExtendedBaseResponse<UserPlaylistDto> getUserPlaylistById(Long id);

}
