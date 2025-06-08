package com.trex.iot_backend.Controller;

import com.trex.iot_backend.Service.ImageService;
import com.trex.iot_backend.model.PicModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/image")
@Slf4j
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<PicModel> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            PicModel saved = imageService.save(file);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            log.error("Image upload failed: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PicModel> getImage(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(imageService.findById(id));
        } catch (Exception e) {
            log.error("Image not found: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PicModel>> getAllImages() {
        try {
            return ResponseEntity.ok(imageService.findAll());
        } catch (Exception e) {
            log.error("Failed to fetch images: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable Long id) {
        try {
            imageService.deleteById(id);
            return ResponseEntity.ok("Image deleted successfully");
        } catch (Exception e) {
            log.error("Failed to delete image: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found or already deleted");
        }
    }
}
