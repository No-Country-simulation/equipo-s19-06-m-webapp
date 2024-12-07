package com.web.app.controllers;

import com.web.app.dto.BaseResponse;
import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.favorite.FavoriteRequest;
import com.web.app.dto.favorite.FavoriteResponse;
import com.web.app.service.FavoritesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {

    private final FavoritesService service;

    private FavoritesController(FavoritesService service){
        this.service = service;
    }

    @Operation(summary = "Crear un favorito", description = "Crear un favorito con detalles especificos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Favorito creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Entrada no valida")
    })
    @PostMapping
    public ExtendedBaseResponse<FavoriteResponse> createFavorite(@RequestBody FavoriteRequest request){
        return service.createFavorite(request);
    }


    @Operation(summary = "Obtener todos los Favoritos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Favoritos devueltos exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public ExtendedBaseResponse<List<FavoriteResponse>> getAllFavorites(){
        return service.getAllFavorites();
    }

    @Operation(summary = "Saber si es favorito")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estado devuelto exitosamente"),
            @ApiResponse(responseCode = "404",description = "Favorito no encontrado")
    })
    @GetMapping("/isFavorite")
    public ExtendedBaseResponse<FavoriteResponse> isFavorite(
        @RequestParam Long userId,
        @RequestParam Long trackId) {
       return service.isFavorite(userId,trackId);
    }
    @Operation(summary = "Borrar favoritos de un usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Favorito Borrado"),
            @ApiResponse(responseCode = "404", description = "Favorito no enccontrado")
    })
    @DeleteMapping("/clearFavorites")
    public ExtendedBaseResponse<FavoriteResponse> clearFavorites(@RequestParam Long userId){
         service.clearFavorite(userId);
         return ExtendedBaseResponse.of(BaseResponse.ok("Favorites cleared successfully"), null);
    }

}
