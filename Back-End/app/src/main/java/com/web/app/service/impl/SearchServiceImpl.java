package com.web.app.service.impl;

import com.web.app.dto.search.db.SearchDBResultDTO;
import com.web.app.mapper.SearchMapper;
import com.web.app.repository.TrackRepository;
import com.web.app.service.api.DeezerClient;
import com.web.app.dto.BaseResponse;
import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.search.SearchDeezerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SearchServiceImpl {
    private final DeezerClient deezerClient;
    private final TrackRepository trackRepository;
    private final SearchMapper searchMapper;

    public ExtendedBaseResponse<SearchDeezerResponse> searchDeezaer(String artist, String track, String album) {
        SearchDeezerResponse response = deezerClient.searchDeezerAPI(artist, track, album);
        return ExtendedBaseResponse.of(BaseResponse.ok("Busqueda por Deezer Exitoso"), response);
    }

    public ExtendedBaseResponse<List<SearchDBResultDTO>> searchDB(String data) {
        List<Object[]> response = trackRepository.findMusicBySearchTerm(data);
        return ExtendedBaseResponse.of(BaseResponse.ok("Busqueda por Base de Datos Exitosa")
                , searchMapper.mapToSearchDBResultDTO(response));
    }
}
