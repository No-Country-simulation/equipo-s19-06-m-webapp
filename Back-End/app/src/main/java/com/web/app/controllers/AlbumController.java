package com.web.app.controllers;

import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.album.AlbumRequest;
import com.web.app.dto.album.AlbumResponse;
import com.web.app.service.AlbumService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Albumes", description = "Gestionar todos los End-Points de albumes.")
@RestController
@RequestMapping("/albums")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService service;

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
    public ResponseEntity<ExtendedBaseResponse<AlbumResponse>> createDeezerAlbum (@Valid @RequestBody AlbumRequest request) {
        ExtendedBaseResponse<AlbumResponse> albumResponse = service.createDeezerAlbum(request);
        return ResponseEntity.status(201).body(albumResponse);
    }

}
