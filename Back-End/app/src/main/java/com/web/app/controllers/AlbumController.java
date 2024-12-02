package com.web.app.controllers;

import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.album.AlbumResponse;
import com.web.app.service.AlbumService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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
                    description = "Album creado exitosamente."
            ),

            @ApiResponse(
                    responseCode = "404",
                    description = "Album no encontrado.",
                    content = @Content
            )
    })
    @PostMapping("/import/{id}")
    public ResponseEntity<ExtendedBaseResponse<URI>> createDeezerAlbum (
            @Parameter(
                    name = "id",
                    example = "15103893",
                    required = true
            )
            @PathVariable long id
    ) {
        ExtendedBaseResponse<URI> albumResponse = service.createDeezerAlbum(id);
        return ResponseEntity.status(201).body(albumResponse);
    }

    @Operation(summary = "Busca un album.",
            description = "Busca un album por id en la base de datos.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Album encontrado."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Album no encontrado.",
                    content = @Content
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<ExtendedBaseResponse<AlbumResponse>> findAlbum (
            @Parameter(
                    name = "id",
                    example = "15103893",
                    required = true
            )
            @PathVariable long id
    ) {
        ExtendedBaseResponse<AlbumResponse> albumResponse = service.findAlbum(id);
        return ResponseEntity.ok(albumResponse);
    }

}
