package com.web.track.controller;

import com.web.track.dto.ExtendedBaseResponse;
import com.web.track.dto.track.TrackRequest;
import com.web.track.dto.track.TrackResponse;
import com.web.track.service.TrackService;
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
@RequestMapping("/tracks")
@RequiredArgsConstructor
public class TrackController {

    private final TrackService service;

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
    public ExtendedBaseResponse<List<TrackResponse>> findTracksByAlbumId(@PathVariable Long albumId) {
        return service.findTracksByAlbumId(albumId);
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
    public ExtendedBaseResponse<TrackResponse> createDeezerTrack(@Valid @RequestBody TrackRequest request) {
        return service.createDeezerTrack(request);
    }

}
