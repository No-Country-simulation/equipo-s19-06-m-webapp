package com.web.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Artist {
    @Id
    private Long id;
    private String name;
    private String pictureUrl;
    private Long fanNum;
    @OneToOne
    private User user;
    @OneToMany(mappedBy = "artist")
    private List<Album> albums;
}
