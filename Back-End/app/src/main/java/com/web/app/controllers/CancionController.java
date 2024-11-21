package com.web.app.controllers;

import com.web.app.dto.CancionRequest;
import com.web.app.service.CancionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/canciones")
@RequiredArgsConstructor
public class CancionController {

    private final CancionService service;

    @PostMapping
    public void anadirCancion (@RequestBody CancionRequest request) {
        service.anadirCancion(request);
    }

}
