package com.web.app.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record LoginRequestDto(

        @Email(message = "El correo electrónico debe ser valido, utilizando ´@´")
        @NotBlank(message = "El correo electrónico no puede estar en blanco")
        String email,

        @NotBlank(message = "La contraseña no puede estar en blanco")
        String password

) implements Serializable {
}
