package com.web.app.repository;

import com.web.app.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepository extends JpaRepository<Cancion, Long> {
}
