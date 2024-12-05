package com.web.app.service;

import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.favorite.FavoriteRequest;
import com.web.app.dto.favorite.FavoriteResponse;
import com.web.app.repository.FavoritesRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface FavoritesService {

    public ExtendedBaseResponse<FavoriteResponse> createFavorite(FavoriteRequest request);
    public ExtendedBaseResponse<FavoriteResponse> updateFavorite(FavoriteRequest request);
    public ExtendedBaseResponse<List<FavoriteResponse>> getAllFavorites();
    public ExtendedBaseResponse<FavoriteResponse> isFavorite(Long userId, Long trackId);
    public ExtendedBaseResponse<FavoriteResponse> clearFavorite(Long userId);

    }



