package com.web.app.service.impl;

import com.web.app.service.api.DeezerClient;
import com.web.app.dto.BaseResponse;
import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.search.SearchDeezerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SearchServiceImpl {
    public final DeezerClient deezerClient;
    public ExtendedBaseResponse<SearchDeezerResponse> searchDeezaer(String artist, String track, String album) {
        SearchDeezerResponse response=deezerClient.searchDeezerAPI(artist, track, album);
        return ExtendedBaseResponse.of(BaseResponse.ok("Busqueda por Deezer Exitoso"), response);
    }
}
