package com.web.app.dto.favorite;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavoriteResponse {
    private Long favoritesId;
    private Long userId;
    private Long trackId;
}
