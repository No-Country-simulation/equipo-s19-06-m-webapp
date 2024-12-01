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
    @Column(name = "picture_url", length = 1024)
    private String pictureUrl;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Genre> genres;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Track> tracks;
    @ManyToOne
    private Artist artist;
}
