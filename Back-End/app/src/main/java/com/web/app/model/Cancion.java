package com.web.app.model;


import jakarta.persistence.*;
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
    private String genero;
    private String urlImg;
    @ManyToOne
    private Album album;
    private String url;
}
