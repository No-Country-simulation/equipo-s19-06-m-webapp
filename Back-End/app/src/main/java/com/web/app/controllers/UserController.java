package com.web.app.controllers;

import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.user.*;
import com.web.app.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Usuarios", description = "Gestionar todos los End-Points de usuarios.")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(
            summary = "Actualizar la imagen de un usuario",
            description = "Permite actualizar la imagen de perfil de un usuario proporcionado su ID y una nueva imagen."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Imagen actualizada exitosamente.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExtendedBaseResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuario no encontrado.",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error al actualizar la imagen.",
                    content = @Content
            )
    })
    @PostMapping(value = "/images/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ExtendedBaseResponse<String>> updateUserImage(@Valid @ModelAttribute UpDateImagesUserDto dto) {
        ExtendedBaseResponse<String> datos = userService.upDateImagesUser(dto);
        return ResponseEntity.status(201).body(datos);
    }

    @Operation(
            summary = "Eliminar la imagen de un usuario",
            description = "Permite eliminar la imagen de perfil de un usuario dado su ID y la URL de la imagen."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Imagen eliminada exitosamente.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExtendedBaseResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuario no encontrado.",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error al eliminar la imagen.",
                    content = @Content
            )
    })
    @DeleteMapping("/images/delete")
    public ResponseEntity<ExtendedBaseResponse<String>> deleteUserImage(@Valid @RequestBody DeleteImagesUserDto dto) {
        ExtendedBaseResponse<String> datos = userService.deleteImagesUser(dto);
        return ResponseEntity.ok(datos);
    }

    @Operation(
            summary = "Buscar usuario por ID",
            description = "Obtiene los datos de un usuario según su ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuario encontrado exitosamente.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuario no encontrado.",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error al buscar el usuario.",
                    content = @Content
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<ExtendedBaseResponse<UserDto>> findUserById(@PathVariable Long id) {
        ExtendedBaseResponse<UserDto> response = userService.findUserById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Actualizar datos de un usuario",
            description = "Permite actualizar los datos de un usuario proporcionado su ID y los nuevos valores."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuario actualizado exitosamente.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UpdatedUserDto.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuario no encontrado.",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error al actualizar los datos del usuario.",
                    content = @Content
            )
    })
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ExtendedBaseResponse<UpdatedUserDto> updateUser(@Valid @RequestBody UpdateUserDto updateUserDto) {
        return userService.updateUser(updateUserDto);
    }
}
