package com.web.app.service.impl;

import com.web.app.dto.BaseResponse;
import com.web.app.dto.ExtendedBaseResponse;
import com.web.app.dto.user.UpDateImagesUserDto;
import com.web.app.dto.user.DeleteImagesUserDto;
import com.web.app.exception.userExc.UserNotFoundException;
import com.web.app.model.User;
import com.web.app.repository.UserRepository;
import com.web.app.service.UserService;
import com.web.app.service.api.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ImageService imageService;
    private final UserRepository userRepository;
    @Override
    @Transactional
    public ExtendedBaseResponse<String> upDateImagesUser(UpDateImagesUserDto upDateImagesUser) {
        String imageUrl = uploadSingleImage(upDateImagesUser.getImage());
        User user  = userRepository.findById(upDateImagesUser.getUserId()).orElseThrow(() ->
                new UserNotFoundException("This User Does Not Exist with that Id: " + upDateImagesUser.getUserId()));
        user.setUserImage(imageUrl);
        User savedUser = userRepository.save(user);
        return ExtendedBaseResponse.of(BaseResponse.created("Image Updated Successfully"), savedUser.getUserImage());
    }

    @Override
    @Transactional
    public ExtendedBaseResponse<String> deleteImagesUser(DeleteImagesUserDto deleteImagesUser) {
        deleteSingleImage(deleteImagesUser.url());
        User user  = userRepository.findById(deleteImagesUser.userId()).orElseThrow(() ->
                new UserNotFoundException("This User Does Not Exist with that Id: " + deleteImagesUser.userId()));
        user.setUserImage(null);
        User savedUser = userRepository.save(user);
        return ExtendedBaseResponse.of(BaseResponse.created("Image Deleted Successfully"), savedUser.getUserImage());
    }


    private String uploadSingleImage(MultipartFile image) {
        try {
            return imageService.uploadImage(image);
        } catch (IOException e) {
            throw new RuntimeException("Error uploading image", e);
        }
    }

    private void deleteSingleImage(String imageUrl) {
        try {
            imageService.deleteImage(imageUrl);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting image", e);
        }
    }

}
