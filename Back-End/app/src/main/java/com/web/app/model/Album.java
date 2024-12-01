package com.web.app.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Album {
    @Id
    private long id;
    private String name;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Genre> genres;
    @Column(name = "picture_url", length = 1024)
    private String pictureUrl;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Track> tracks;
}
