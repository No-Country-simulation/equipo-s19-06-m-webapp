package com.web.app.dto.favorite;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class FavoriteRequest {
    private Long userId;
    private Long trackId;
}
