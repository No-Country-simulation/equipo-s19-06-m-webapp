package com.web.app.dto.search.db;

public record SearchDBResponse(
    String track,
    String album,
    String picture_url,
    String type,
    Long id
) {
//    public SearchDBResponse(String track, String album, String pictureUrl, String type, Long id) {
//        this.track = track;
//        this.album = album;
//        this.pictureUrl = pictureUrl;
//        this.type = type;
//        this.id = id;
//    }
}
