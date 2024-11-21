package com.web.song.song;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cancion {
    @Id
    private long id;
    private String nombre;
    private int duracion;
    @Column(name = "album_id")
    private Long albumId;
    private String url;
}
