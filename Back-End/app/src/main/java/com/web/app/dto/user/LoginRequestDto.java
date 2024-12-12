package com.web.app.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record LoginRequestDto(
@Schema(example = "ejemplo@gmail.com")
        @Email(message = "El correo electrónico debe ser valido, utilizando ´@´")
        @NotBlank(message = "El correo electrónico no puede estar en blanco")
        String email,
@Schema(example = "12345678Ej+")
        @NotBlank(message = "La contraseña no puede estar en blanco")
        String password

) implements Serializable {
}
