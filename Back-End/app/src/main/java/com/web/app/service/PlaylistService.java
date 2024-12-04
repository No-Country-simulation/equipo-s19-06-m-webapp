package com.web.app.service;

import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.playlist.CreatePlaylistDto;
import com.web.app.dto.playlist.PlaylistDto;
import com.web.app.dto.playlist.UpdatePlaylistDto;
import com.web.app.model.Playlist;

import java.util.List;

public interface PlaylistService {

    ExtendedBaseResponse<PlaylistDto> createPlaylist(CreatePlaylistDto dto);
    ExtendedBaseResponse<PlaylistDto> updatePlaylist(UpdatePlaylistDto dto);
    ExtendedBaseResponse<String> deletePlaylist(Long id);
    ExtendedBaseResponse<List<PlaylistDto>> getAllPlaylists();
    ExtendedBaseResponse<PlaylistDto> getPlaylistById(Long id);


}
