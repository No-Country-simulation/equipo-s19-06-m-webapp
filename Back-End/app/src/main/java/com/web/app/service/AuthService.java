package com.web.app.service;

import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.user.AuthResponseDto;
import com.web.app.dto.user.LoginRequestDto;
import com.web.app.dto.user.RegisterRequestDto;

public interface AuthService {
    ExtendedBaseResponse<AuthResponseDto> login(LoginRequestDto request);

    ExtendedBaseResponse<AuthResponseDto> register(RegisterRequestDto request);

}
