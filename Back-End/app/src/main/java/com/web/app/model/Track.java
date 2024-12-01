package com.web.app.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Track {
    @Id
    private long id;
    private String name;
    private int duration;
    @Column(name = "preview_url", length = 1024)
    private String previewUrl;
    @ManyToOne
    private Album album;
}
