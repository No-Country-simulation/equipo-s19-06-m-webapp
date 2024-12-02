package com.web.app.repository;

import com.web.app.dto.search.db.SearchDBResponse;
import com.web.app.dto.search.db.SearchDBResponseProjection;
import com.web.app.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {
    List<Track> findAllByAlbumId(Long albumId);

    @Query(value = """
                SELECT 
                    t.name AS track, 
                    al.name AS album, 
                    al.picture_url AS pictureUrl, 
                    'track' AS type, 
                    t.id AS id
                FROM Track t
                JOIN Album al ON t.album_id = al.id
                WHERE t.name LIKE %:searchTerm%

                UNION

                SELECT 
                    t.name AS track, 
                    al.name AS album, 
                    al.picture_url AS pictureUrl, 
                    'album' AS type, 
                    al.id AS id
                FROM Track t
                JOIN Album al ON t.album_id = al.id
                WHERE al.name LIKE %:searchTerm%
                LIMIT 10 
            """, nativeQuery = true)
    List<SearchDBResponseProjection> findMusicBySearchTerm(@Param("searchTerm") String searchTerm);

}
