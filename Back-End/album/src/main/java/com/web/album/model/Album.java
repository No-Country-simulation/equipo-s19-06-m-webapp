package com.web.album.model;

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
    private String name;
    @Column(name = "release_date")
    private String releaseDate;
//    private List<String> genres;
    @Column(name = "picture_url", length = 1024)
    private String pictureUrl;
}
