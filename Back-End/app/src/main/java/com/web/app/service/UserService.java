package com.web.app.service;

import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.user.UpDateImagesUserDto;
import com.web.app.dto.user.DeleteImagesUserDto;

public interface UserService {

    ExtendedBaseResponse<String> upDateImagesUser(UpDateImagesUserDto upDateImagesUser);

    ExtendedBaseResponse<String> deleteImagesUser(DeleteImagesUserDto deleteImagesUser);

}
