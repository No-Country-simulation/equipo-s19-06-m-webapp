package com.web.app.dto.playlist;

import lombok.Data;

@Data
public class UpdatePlaylistDto {

    private Long id;

    private String name;

    private Long userId;
}
