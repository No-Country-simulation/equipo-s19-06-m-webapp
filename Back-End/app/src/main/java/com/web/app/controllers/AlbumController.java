package com.web.app.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/albumes")
@RestController
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @PostMapping
    public void anadirAlbum (@RequestBody AlbumRequest request) {
        albumService.anadirAlbum(request);
    }
}
