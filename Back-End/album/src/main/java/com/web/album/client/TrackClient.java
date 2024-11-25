package com.web.album.client;

import com.web.album.dto.ExtendedBaseResponse;
import com.web.album.dto.track.TrackRequest;
import com.web.album.dto.track.TrackResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "track-service",
        url = "http://localhost:8060/tracks"
)
public interface TrackClient {

    @GetMapping("/album/{albumId}")
    ExtendedBaseResponse<List<TrackResponse>> findTracksByAlbumId(@PathVariable Long albumId);

    @PostMapping
    void createTrack(@RequestBody TrackRequest trackRequest);
}
