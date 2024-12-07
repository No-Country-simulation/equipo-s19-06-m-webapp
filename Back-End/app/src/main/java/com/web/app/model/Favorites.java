package com.web.app.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "favorites")
@Getter
@Setter
@NoArgsConstructor
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_favorites")
    private Long idFavorites;

    @Column(name = "fk_id_user", nullable = false)
    private Long userId;

    @Column(name = "fk_id_track", nullable = false)
    private Long trackId;
}
