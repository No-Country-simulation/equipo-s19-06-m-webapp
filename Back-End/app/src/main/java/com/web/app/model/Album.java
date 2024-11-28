package com.web.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
    @Column(name = "release_date")
    private String releaseDate;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Genre> genres;
    @Column(name = "picture_url", length = 1024)
    private String pictureUrl;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Track> tracks;
}
