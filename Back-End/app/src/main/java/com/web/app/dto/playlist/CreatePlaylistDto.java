package com.web.app.dto.playlist;

import lombok.Data;

@Data
public class CreatePlaylistDto {

    private String name;

    private Long userId;

    public CreatePlaylistDto(String name, Long id) {
    }
}
