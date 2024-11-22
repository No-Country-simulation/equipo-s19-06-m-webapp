package com.web.app.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class UpDateImagesUserDto {

        @NotNull(message = "La 'imagen' no puede estar vacía.")
        private MultipartFile image;

        @NotNull(message = "El 'ID del usuario' no puede estar vacío.")
        private Long userId;

}

