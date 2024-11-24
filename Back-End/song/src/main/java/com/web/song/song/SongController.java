package com.web.song.song;

import com.web.song.base.ExtendedBaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService service;

    @Operation(summary = "Obtiene canciones por album id.", description = "Obtiene canciones por album id.")
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Canciones obtenidos.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ExtendedBaseResponse.class))
                    })
    })
    @GetMapping("/album/{albumId}")
    public ExtendedBaseResponse<List<SongResponse>> findSongsByAlbumId(@PathVariable Long albumId) {
        return service.findSongsByAlbumId(albumId);
    }

    @Operation(summary = "Crea una cancion con la api Deezer.", description = "Crea una cancion con la api Deezer.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Cancion creada.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ExtendedBaseResponse.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Cancion no encontrada.",
                    content = @Content
            )
    })
    @PostMapping
    public ExtendedBaseResponse<SongResponse> createDeezerSong (@Valid @RequestBody SongRequest request) {
        return service.createDeezerSong(request);
    }

}
