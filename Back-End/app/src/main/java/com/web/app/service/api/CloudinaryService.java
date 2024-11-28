package com.web.app.service.api;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService {
    private final Cloudinary cloudinary;

    public CloudinaryService(@Value("${cloudinary.cloud.name}") String cloudName,
                             @Value("${cloudinary.api.key}") String apiKey,
                             @Value("${cloudinary.api.secret}") String apiSecret) {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret));
    }

    // Metodo para subir un video a Cloudinary
    public String uploadVideo(String name, String publicId, String videoUrl) {
        try {
            Map<String, Object> uploadParams = new HashMap<>();
            uploadParams.put("resource_type", "");
            uploadParams.put("display_name", name);
            uploadParams.put("public_id", publicId);
            uploadParams.put("folder", "tracks");

            Map uploadResult = cloudinary.uploader().upload(videoUrl, uploadParams);
            return uploadResult.get("url").toString();
        } catch (IOException ex) {
            throw new RuntimeException("Error subiendo un video", ex);
        }
    }
}
