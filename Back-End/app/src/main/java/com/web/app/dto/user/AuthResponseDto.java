package com.web.app.dto.user;

import java.io.Serializable;

public record AuthResponseDto(
        Long id,
        String username,
        String token

) implements Serializable {
}

