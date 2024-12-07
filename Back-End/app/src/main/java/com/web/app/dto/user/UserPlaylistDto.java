package com.web.app.dto.user;

import com.web.app.model.Playlist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPlaylistDto {

    private Long id;
    private Long user_id;
    private Long playlistId;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;


}
