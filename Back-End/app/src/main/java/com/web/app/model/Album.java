package com.web.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Album {
    @Id
    private Long id;
    private String nombre;
    private Year anioLanzamiento;
}
