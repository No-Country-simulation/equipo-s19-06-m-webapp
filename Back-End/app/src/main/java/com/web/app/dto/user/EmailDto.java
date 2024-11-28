package com.web.app.dto.user;

import java.io.Serializable;

public record EmailDto(
        String email

) implements Serializable {
}
