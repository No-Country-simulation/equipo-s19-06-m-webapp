package com.web.album.album;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Album {
    @Id
    private long id;
    private String name;
    private String releaseDate;
//    private List<String> genres;
    @Column(length = 1024)
    private String urlImg;
}
