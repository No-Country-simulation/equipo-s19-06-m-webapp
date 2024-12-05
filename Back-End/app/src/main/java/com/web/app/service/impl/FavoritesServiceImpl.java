package com.web.app.service.impl;
import com.web.app.dto.BaseResponse;
import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.favorite.FavoriteRequest;
import com.web.app.dto.favorite.FavoriteResponse;
import com.web.app.mapper.FavoritesMapper;
import com.web.app.model.Favorites;
import com.web.app.repository.FavoritesRepository;
import com.web.app.service.FavoritesService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoritesServiceImpl implements FavoritesService {

    private final FavoritesRepository repository;
    private final FavoritesMapper mapper;

    public FavoritesServiceImpl(FavoritesRepository repository, FavoritesMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ExtendedBaseResponse<FavoriteResponse> createFavorite(FavoriteRequest request) {
        Favorites favorite = mapper.toEntity(request);
        Favorites saved = repository.save(favorite);
        return ExtendedBaseResponse.of(BaseResponse.created("Favorite created successfully"), mapper.toResponse(saved));
    }

    @Override
    public ExtendedBaseResponse<FavoriteResponse> updateFavorite(FavoriteRequest request) {
        Favorites favorite = mapper.toEntity(request);
        favorite.setTrackId(request.getTrackId());
        favorite.setUserId(request.getUserId());
        Favorites updated = repository.save(favorite);
        return ExtendedBaseResponse.of(BaseResponse.ok("Playlist updated successfully"), mapper.toResponse(updated));
    }

    @Override
    public ExtendedBaseResponse<List<FavoriteResponse>> getAllFavorites() {
        List<Favorites> favorites = repository.findAll();
        List<FavoriteResponse> responseList = favorites.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        return ExtendedBaseResponse.of(BaseResponse.ok("Favorites fetched successfully"), responseList);
    }

    @Override
    public ExtendedBaseResponse<FavoriteResponse> isFavorite(Long userId, Long trackId) {
        boolean exists = repository.findByUserIdAndTrackId(userId, trackId).isPresent();
        return ExtendedBaseResponse.of(
                BaseResponse.ok(exists ? "The track is a favorite" : "The track is not favorite"),
                null
        );
    }

    @Override
    public ExtendedBaseResponse<FavoriteResponse> clearFavorite(Long userId) {
        repository.deleteByUserId(userId);
        return ExtendedBaseResponse.of(BaseResponse.ok("Favorites cleared successfully"), null);
    }
}
