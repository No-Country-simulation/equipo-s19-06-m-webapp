package com.web.app.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserPlaylistDto {

    @NotNull(message = "User Playlist ID is required.")
    private Long id;

    @NotNull(message = "Playlist ID is required.")
    private Long playListId;

    private LocalDateTime updated_at;


    public Long getPlaylistId() {
        return playListId;
    }

    public void setPlaylist(Long playList) {
        this.playListId = playList;
    }
}
