package com.web.app.controllers;

import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.track.TrackResponse;
import com.web.app.service.TrackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
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

    @Operation(summary = "Crea una pista con la api Deezer.", description = "Crea una pista con la api Deezer.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Pista creada."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pista no encontrada.",
                    content = @Content
            )
    })
    @PostMapping("/import/{id}")
    public ResponseEntity<ExtendedBaseResponse<URI>> createDeezerTrack(@PathVariable long id) throws IOException {
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
    public ResponseEntity<ExtendedBaseResponse<TrackResponse>> findTrack(@PathVariable long id) throws IOException {
        ExtendedBaseResponse<TrackResponse> trackResponse = service.findTrack(id);
        return ResponseEntity.ok(trackResponse);
    }

}
