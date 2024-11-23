package com.web.album.album;

import com.web.album.base.ExtendedBaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService service;

    @GetMapping("/{id}")
    public ExtendedBaseResponse<AlbumWithoutTracksResponse> findAlbum(@PathVariable Long id) {
        return service.findAlbumWithoutTracks(id);
    }

    @Operation(summary = "Crea un album con la Api Deezer",
            description = "Crea un album de la Api Deezer y todas las canciones del album")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Album creado",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ExtendedBaseResponse.class))
                    })
    })
    @PostMapping
    public ExtendedBaseResponse<AlbumResponse> createDeezerAlbum (@RequestBody AlbumRequest request) {
        return service.createDeezerAlbum(request);
    }

}
