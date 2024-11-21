package com.web.app.dto;

import java.util.List;

public record Tracks(
        List<CancionAPIResponse> data
) {}