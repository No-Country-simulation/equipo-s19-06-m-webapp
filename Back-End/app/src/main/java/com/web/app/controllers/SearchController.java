package com.web.app.controllers;

import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.search.SearchDeezerResponse;
import com.web.app.service.impl.SearchServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Buscador", description = "Buscar canciones, album, artist tanto desde la API de Deezar como la nuestra")
@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
    public final SearchServiceImpl searchService;
    // Implementación de los métodos para buscar canciones, albums y artistas
    @Operation(summary = "Buscador",
            description = "Al Buscar canciones, album, artist, hacerlo entre comillas"
    )
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Busqueda por API Deezer Exitoso.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ExtendedBaseResponse.class))
                    })
    })
    @GetMapping
    public ExtendedBaseResponse<SearchDeezerResponse> findTracksByAlbumId(
            @RequestParam(required = false) String artist,
            @RequestParam(required = false) String track,
            @RequestParam(required = false) String album) {
        return searchService.searchDeezaer(artist,track,album);
    }
}