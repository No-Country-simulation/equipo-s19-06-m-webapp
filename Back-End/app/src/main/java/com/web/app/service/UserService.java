package com.web.app.service;

import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.user.*;

public interface UserService {

    ExtendedBaseResponse<String> upDateImagesUser(UpDateImagesUserDto upDateImagesUser);

    ExtendedBaseResponse<String> deleteImagesUser(DeleteImagesUserDto deleteImagesUser);

    ExtendedBaseResponse<UserDto> findUserById(Long id);

    ExtendedBaseResponse<UpdatedUserDto> updateUser(UpdateUserDto updateUserDto);

}
