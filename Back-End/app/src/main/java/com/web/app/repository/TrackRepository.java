package com.web.app.repository;

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
                ar.name AS artist,
                al.picture_url,
                'track' AS type,
                t.id AS id
            FROM
                Track t
                    JOIN
                Album al ON t.album_id = al.id
                    JOIN
                Artist ar ON al.artist_id = ar.id
            WHERE
                t.name LIKE %:searchTerm%
            UNION SELECT
                NULL AS track,
                al.name AS album,
                NULL AS artist,
                al.picture_url,
                'album' AS type,
                al.id AS id
            FROM
                Track t
                    JOIN
                Album al ON t.album_id = al.id
                    JOIN
                Artist ar ON al.artist_id = ar.id
            WHERE
                al.name LIKE %:searchTerm%
            UNION SELECT
                NULL AS track,
                NULL AS album,
                ar.name AS artist,
                ar.pictureUrl AS picture_url,
                'artist' AS type,
                ar.id AS id
            FROM
                Track t
                    JOIN
                Album al ON t.album_id = al.id
                    JOIN
                Artist ar ON al.artist_id = ar.id
            WHERE
                ar.name LIKE %:searchTerm%;
            """, nativeQuery = true)
    List<SearchDBResponseProjection> findMusicBySearchTerm(@Param("searchTerm") String searchTerm);

}
