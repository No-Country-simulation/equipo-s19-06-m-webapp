package com.web.album.album;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Album {
    @Id
    private long id;
    private String nombre;
    private int fechaLanzamiento;
    private String genero;
    private String urlImg;
}
