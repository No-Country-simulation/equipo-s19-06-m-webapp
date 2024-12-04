package com.web.app.controllers;


import com.web.app.dto.ExtendedBaseResponse;

import com.web.app.dto.user.CreateUserPlaylistDto;
import com.web.app.dto.user.UpdateUserPlaylistDto;
import com.web.app.dto.user.UserPlaylistDto;
import com.web.app.service.UserPlaylistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User Playlists", description = "Manage user playlists.")
@RestController
@RequestMapping("/user-playlists")
@RequiredArgsConstructor
public class UserPlaylistController {

    private final UserPlaylistService userPlaylistService;

    @PostMapping
    @Operation(summary = "Create a User Playlist")
    public ResponseEntity<ExtendedBaseResponse<UserPlaylistDto>> createUserPlaylist(
            @RequestBody CreateUserPlaylistDto dto) {
        return ResponseEntity.status(201).body(userPlaylistService.createUserPlaylist(dto));
    }

    @PutMapping
    @Operation(summary = "Update a User Playlist")
    public ResponseEntity<ExtendedBaseResponse<UserPlaylistDto>> updateUserPlaylist(
            @RequestBody UpdateUserPlaylistDto dto) {
        return ResponseEntity.ok(userPlaylistService.updateUserPlaylist(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a User Playlist")
    public ResponseEntity<ExtendedBaseResponse<String>> deleteUserPlaylist(@PathVariable Long id) {
        return ResponseEntity.ok(userPlaylistService.deleteUserPlaylist(id));
    }

    @GetMapping
    @Operation(summary = "Get all User Playlists")
    public ResponseEntity<ExtendedBaseResponse<List<UserPlaylistDto>>> getAllUserPlaylists() {
        return ResponseEntity.ok(userPlaylistService.getAllUserPlaylists());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a User Playlist by ID")
    public ResponseEntity<ExtendedBaseResponse<UserPlaylistDto>> getUserPlaylistById(@PathVariable Long id) {
        return ResponseEntity.ok(userPlaylistService.getUserPlaylistById(id));
    }
}

