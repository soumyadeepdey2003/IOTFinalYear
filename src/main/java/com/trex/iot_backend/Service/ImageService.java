package com.trex.iot_backend.Service;

import com.cloudinary.Cloudinary;
import com.trex.iot_backend.Config.ConfigProject;
import com.trex.iot_backend.Repository.PicRepository;
import com.trex.iot_backend.model.PicModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageService {


    private final PicRepository picRepository;
    private final ConfigProject configProject;

    public PicModel save(MultipartFile file,String location) throws Exception {
        try {
            Map uploadResult = uploadImage(file);
            String imageUrl = (String) uploadResult.get("secure_url");

            PicModel picModel = new PicModel();
            picModel.setLocation(location);
            picModel.setDate(LocalDateTime.now());
            picModel.setImg(imageUrl);

            log.info("Image uploaded and saved successfully");
            return picRepository.save(picModel);

        } catch (Exception e) {
            log.error("Error saving image", e);
            throw new Exception("Error saving image: " + e.getMessage());
        }
    }

    public Map uploadImage(MultipartFile file) throws Exception {
        try {
            Cloudinary cloudinary = configProject.coudinaryConfig();
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), Map.of());
            log.info("Image uploaded to Cloudinary successfully");
            return uploadResult;

        } catch (Exception e) {
            log.error("Error uploading image", e);
            throw new Exception("Error uploading image: " + e.getMessage());
        }
    }

    public PicModel findById(Long id) throws Exception {
        log.info("Finding image by ID: {}", id);
        try {
            Optional<PicModel> optionalPic = picRepository.findById(id);
            return optionalPic.orElseThrow(() -> new Exception("Image not found with ID: " + id));
        }
        catch (Exception e) {
            log.error("Error finding image by ID: {}", id, e);
            throw new Exception("Error finding image: " + e.getMessage());
        }

    }

    public List<PicModel> findAll() throws Exception {
        try {
            return picRepository.findAll();
        } catch (Exception e) {
            log.error("Error fetching all images", e);
            throw new Exception("Error fetching all images");
        }
    }

    public void deleteById(Long id) throws Exception {
        try {
            if (!picRepository.existsById(id)) {
                throw new Exception("Image not found with ID: " + id);
            }
            picRepository.deleteById(id);
            log.info("Image with ID {} deleted successfully", id);
        } catch (Exception e) {
            log.error("Error deleting image with ID {}", id, e);
            throw new Exception("Error deleting image: " + e.getMessage());
        }
    }
}
