package com.web.app.service;

import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.user.UpDateImagesUserDto;
import com.web.app.dto.user.DeleteImagesUserDto;
import com.web.app.dto.user.UserDto;

public interface UserService {

    ExtendedBaseResponse<String> upDateImagesUser(UpDateImagesUserDto upDateImagesUser);

    ExtendedBaseResponse<String> deleteImagesUser(DeleteImagesUserDto deleteImagesUser);

    ExtendedBaseResponse<UserDto> findUserById(Long id);

}
