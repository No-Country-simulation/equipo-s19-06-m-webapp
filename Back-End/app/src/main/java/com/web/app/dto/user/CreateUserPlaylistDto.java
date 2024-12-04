package com.web.app.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserPlaylistDto {

    @NotNull(message = "User ID is required.")
    private Long userId;

    @NotNull(message = "Playlist ID is required.")
    private Long playlistId;



}
