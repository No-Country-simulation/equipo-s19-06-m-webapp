package com.web.app.dto.playlist;

import lombok.Data;

@Data
public class CreatePlaylistDto {

    private String name;

    private boolean isPublic;

    private Long userId;

    public CreatePlaylistDto(String name, Long userId, boolean isPublic) {
        this.name = name;
        this.userId = userId;
        this.isPublic = isPublic;
    }
}
