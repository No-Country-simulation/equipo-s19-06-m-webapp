package com.web.app.controllers;

import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.playlist.CreatePlaylistDto;
import com.web.app.dto.playlist.PlaylistDto;
import com.web.app.dto.playlist.UpdatePlaylistDto;
import com.web.app.service.PlaylistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Playlist Controller", description = "Manage Playlists")
@RestController
@RequestMapping("/playlists")
@RequiredArgsConstructor
public class PlaylistController {

   private final PlaylistService playlistService;

   @PostMapping
    @Operation(summary = "Create a playlist")
    public ResponseEntity<ExtendedBaseResponse<PlaylistDto>> createPlaylist(@RequestBody CreatePlaylistDto dto){
        return ResponseEntity.status(201).body(playlistService.createPlaylist(dto));
   }

    @PutMapping
    @Operation(summary = "Update a Playlist")
    public ResponseEntity<ExtendedBaseResponse<PlaylistDto>> updatePlaylist(@RequestBody UpdatePlaylistDto dto){
       return ResponseEntity.ok(playlistService.updatePlaylist(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Playlist")
    public ResponseEntity<ExtendedBaseResponse<String>> deletePlaylist(@PathVariable Long id){
        return ResponseEntity.ok(playlistService.deletePlaylist(id));
    }

    @GetMapping
    @Operation(summary = "Get all playlists")
    public ResponseEntity<ExtendedBaseResponse<List<PlaylistDto>>> getAllPlaylists(){
       return ResponseEntity.ok(playlistService.getAllPlaylists());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get playlist by Id")
    public ResponseEntity<ExtendedBaseResponse<PlaylistDto>> getPlaylistById(Long id){
       return ResponseEntity.ok(playlistService.getPlaylistById(id));
    }

}
