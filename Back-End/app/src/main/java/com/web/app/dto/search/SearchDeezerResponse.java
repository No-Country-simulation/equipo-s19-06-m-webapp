package com.web.app.dto.search;

import java.util.ArrayList;

public record SearchDeezerResponse(
        ArrayList<DataResponseBySearch> data,
        int total,
        String next
) {
}
