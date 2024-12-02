package com.web.app.controllers;

import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.track.TrackResponse;
import com.web.app.service.TrackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;

@Tag(name = "Pistas", description = "Gestionar todos los End-Points de pistas.")
@RestController
@RequestMapping("/tracks")
@RequiredArgsConstructor
public class TrackController {

    private final TrackService service;

    @Operation(summary = "Crea una pista con su album y su artist con la Api Deezer.",
            description = "Crea una pista con su album y su artist con la Api Deezer.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Pista creada.",
                    content = @Content(
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "    \"isError\": false,\n" +
                                            "    \"code\": 201,\n" +
                                            "    \"status\": \"Created\",\n" +
                                            "    \"message\": \"Pista creada.\",\n" +
                                            "    \"data\": \"http://localhost:8080/tracks/15103893\"\n" +
                                            "}"
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pista no encontrada.",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor.",
                    content = @Content
            )
    })
    @PostMapping("/import/{id}")
    public ResponseEntity<ExtendedBaseResponse<URI>> createDeezerTrack(
            @Parameter(name = "id", example = "140295501", required = true)
            @PathVariable long id
    ) throws IOException {
        ExtendedBaseResponse<URI> trackResponse = service.createDeezerTrack(id);
        return ResponseEntity.status(201).body(trackResponse);
    }

    @Operation(summary = "Busca una pista.", description = "Busca una pista por id en la base de datos.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Pista creada."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pista no encontrada.",
                    content = @Content
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<ExtendedBaseResponse<TrackResponse>> findTrack(
            @Parameter(name = "id", example = "140295501", required = true)
            @PathVariable long id
    ) throws IOException {
        ExtendedBaseResponse<TrackResponse> trackResponse = service.findTrack(id);
        return ResponseEntity.ok(trackResponse);
    }

}
