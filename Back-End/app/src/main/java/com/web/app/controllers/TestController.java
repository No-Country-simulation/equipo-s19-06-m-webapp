package com.web.app.controllers;


import com.web.app.dto.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Test", description = "Test the API Rest")
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public ResponseEntity<BaseResponse> test() {
        return ResponseEntity.ok(new BaseResponse(
                false,
                200,
                "OK",
                "Bienvenido a la API Rest de Reproductor de musica. Con security"
                )
        );
    }

}
