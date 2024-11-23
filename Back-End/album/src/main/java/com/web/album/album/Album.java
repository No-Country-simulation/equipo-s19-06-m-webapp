package com.web.album.album;

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
    private String urlImg;
}
