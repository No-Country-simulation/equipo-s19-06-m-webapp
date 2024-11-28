package com.web.app.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
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
