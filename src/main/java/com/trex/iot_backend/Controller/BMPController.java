package com.trex.iot_backend.Controller;


import com.trex.iot_backend.Service.BMPService;
import com.trex.iot_backend.model.BMPModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bmp")
@Slf4j
public class BMPController {


    private final BMPService bmpService;

    @PostMapping("/add")
    public ResponseEntity<BMPModel> addBMP(@RequestBody BMPModel bmpModel) throws Exception {
        try {
            log.info("Saving BMPModel {}", bmpModel);
            return ResponseEntity.ok(bmpService.save(bmpModel));
        } catch (Exception e) {
            log.error("Error saving BMPModel {}", bmpModel, e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BMPModel>> getAllBMP() throws Exception {
        try {
            log.info("Getting all BMPModels");
            return ResponseEntity.ok(bmpService.findBmpAll());
        } catch (Exception e) {
            log.error("Error getting all BMPModels", e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BMPModel> getBMP(@PathVariable long id) throws Exception {
        try {
            log.info("Getting BMPModel by id {}", id);
            return ResponseEntity.ok(bmpService.findById(id));
        } catch (Exception e) {
            log.error("Error getting BMPModel by id {}", id, e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBMP(@PathVariable long id) throws Exception {
        try {
            log.info("Deleting BMPModel by id {}", id);
            return ResponseEntity.ok(bmpService.deleteBmp(id));
        } catch (Exception e) {
            log.error("Error deleting BMPModel by id {}", id, e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllBMP() throws Exception {
        try {
            log.info("Deleting all BMPModels");
            return ResponseEntity.ok(bmpService.deleteAllBmp());
        } catch (Exception e) {
            log.error("Error deleting all BMPModels", e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }
}
