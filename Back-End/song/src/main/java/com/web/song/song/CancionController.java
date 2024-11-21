package com.web.song.song;

import com.web.song.song.CancionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
