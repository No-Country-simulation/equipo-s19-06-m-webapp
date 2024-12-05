package com.web.app.mapper;

import com.web.app.dto.BaseResponse;
import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.search.db.AlbumDTO;
import com.web.app.dto.search.db.ArtistDTO;
import com.web.app.dto.search.db.SearchDBResultDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SearchMapper {
    public List<SearchDBResultDTO> mapToSearchDBResultDTO(List<Object[]> results) {
        List<SearchDBResultDTO> dtos = new ArrayList<>();

        for (Object[] row : results) {
            try {
                SearchDBResultDTO dto = new SearchDBResultDTO(
                        (Long) row[0],
                        (String) row[1],
                        (String) row[2],
                        (Integer) row[3],
                        new ArtistDTO(
                                (Long) row[4],
                                (String) row[5],
                                (String) row[6])
                        , new AlbumDTO(
                        (Long) row[7],
                        (String) row[8])
                );
                dtos.add(dto);
            }catch (ClassCastException e){
                System.out.println(e.getMessage());
            }

        }

        return dtos;
    }
}
