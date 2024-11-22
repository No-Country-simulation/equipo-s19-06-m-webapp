package com.web.app.service.api;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageService {
    private final Cloudinary cloudinary;

    public ImageService(@Value("${cloudinary.cloud.name}") String cloudName,
                        @Value("${cloudinary.api.key}") String apiKey,
                        @Value("${cloudinary.api.secret}") String apiSecret) {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret));
    }

    // Método para subir una imagen a Cloudinary
    public String uploadImage(MultipartFile file) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        return uploadResult.get("url").toString(); // Retorna la URL de la imagen subida
    }

    // Método para eliminar una imagen de Cloudinary
    public void deleteImage(String imageUrl) {
        String publicId = extractPublicId(imageUrl);
        try {
            cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
        } catch (IOException e) {
            throw new RuntimeException("Error deleting image from Cloudinary", e);
        }
    }

    // Método auxiliar para extraer el ID público de la URL de la imagen
    private String extractPublicId(String imageUrl) {
        // La URL de la imagen de Cloudinary tiene un formato que incluye el public_id
        // Por ejemplo: "http://res.cloudinary.com/demo/image/upload/v1600131200/sample.jpg"
        // El public_id es "sample"
        String[] parts = imageUrl.split("/");
        String lastPart = parts[parts.length - 1];
        String[] fileNameParts = lastPart.split("\\.");
        return fileNameParts[0];
    }
}
