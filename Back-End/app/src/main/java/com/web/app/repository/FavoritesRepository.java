package com.web.app.repository;

import com.web.app.model.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FavoritesRepository extends JpaRepository<Favorites,Long> {
    Optional<Favorites> findByUserIdAndTrackId(Long userId, Long trackId);
    void deleteByUserId(Long userId);
}
