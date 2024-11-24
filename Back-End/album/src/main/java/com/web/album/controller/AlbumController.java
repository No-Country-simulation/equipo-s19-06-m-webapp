package com.web.album.controller;

import com.web.album.dto.AlbumRequest;
import com.web.album.dto.AlbumResponse;
import com.web.album.service.AlbumService;
import com.web.album.dto.AlbumWithoutTracksResponse;
import com.web.album.base.ExtendedBaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService service;

    @Operation(summary = "Obtiene un album por el id.", description = "Obtiene un album por el id.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Album obtenido.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ExtendedBaseResponse.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Album no encontrado.",
                    content = @Content
            )
    })
    @GetMapping("/{id}")
    public ExtendedBaseResponse<AlbumWithoutTracksResponse> findAlbum(@PathVariable Long id) {
        return service.findAlbumWithoutTracks(id);
    }

    @Operation(summary = "Crea un album con la Api Deezer.",
            description = "Crea un album de la Api Deezer y todas las canciones del album.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Album creado exitosamente.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ExtendedBaseResponse.class))
                    }),

            @ApiResponse(
                    responseCode = "404",
                    description = "Album no encontrado.",
                    content = @Content
            )
    })
    @PostMapping
    public ExtendedBaseResponse<AlbumResponse> createDeezerAlbum (@Valid @RequestBody AlbumRequest request) {
        return service.createDeezerAlbum(request);
    }

}
