package com.web.app.mapper;
import com.web.app.dto.favorite.FavoriteRequest;
import com.web.app.dto.favorite.FavoriteResponse;
import com.web.app.model.Favorites;
import org.springframework.stereotype.Component;

@Component
public class FavoritesMapper {

    public Favorites toEntity(FavoriteRequest request){
        Favorites favorites = new Favorites();
        favorites.setUserId(request.getUserId());
        favorites.setTrackId(request.getTrackId());
        return favorites;
    }

    public  FavoriteResponse toResponse(Favorites entity){
        FavoriteResponse response = new FavoriteResponse();
        response.setFavoritesId(entity.getIdFavorites());
        response.setUserId(entity.getUserId());
        response.setTrackId(entity.getTrackId());
        return response;
    }


}
