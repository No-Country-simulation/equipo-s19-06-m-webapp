package com.web.app.repository;

import com.web.app.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findByGenres_NameIgnoreCase(String genreName);
}
