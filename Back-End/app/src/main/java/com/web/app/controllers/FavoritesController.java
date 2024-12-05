package com.web.app.controllers;

import com.web.app.dto.BaseResponse;
import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.favorite.FavoriteRequest;
import com.web.app.dto.favorite.FavoriteResponse;
import com.web.app.service.FavoritesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {

    private final FavoritesService service;

    private FavoritesController(FavoritesService service){
        this.service = service;
    }

    @PostMapping
    public ExtendedBaseResponse<FavoriteResponse> createFavorite(@RequestBody FavoriteRequest request){
        return service.createFavorite(request);
    }
    @GetMapping
    public ExtendedBaseResponse<List<FavoriteResponse>> getAllFavorites(){
        return service.getAllFavorites();
    }

    @GetMapping("/isFavorite")
    public ExtendedBaseResponse<FavoriteResponse> isFavorite(
        @RequestParam Long userId,
        @RequestParam Long trackId) {
       return service.isFavorite(userId,trackId);
    }

    @DeleteMapping("/clearFavorites")
    public ExtendedBaseResponse<FavoriteResponse> clearFavorites(@RequestParam Long userId){
         service.clearFavorite(userId);
         return ExtendedBaseResponse.of(BaseResponse.ok("Favorites cleared successfully"), null);
    }

}
