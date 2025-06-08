package com.trex.iot_backend.Controller;


import com.trex.iot_backend.Service.Water_LevelService;
import com.trex.iot_backend.model.Water_LevelModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/water_level")
@Slf4j
public class Water_LevelController {

    @Autowired
    private  Water_LevelService water_levelService;

    @PostMapping("/add")
    public ResponseEntity<Water_LevelModel> addWaterLevel(@RequestBody Water_LevelModel water_levelModel) throws Exception {
        try {
            log.info("Saving Water_LevelModel {}", water_levelModel);
            return ResponseEntity.ok(water_levelService.save(water_levelModel));
        } catch (Exception e) {
            log.error("Error saving Water_LevelModel {}", water_levelModel, e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Water_LevelModel>> getAllWaterLevel() throws Exception {
        try {
            log.info("Getting all Water_LevelModels");
            return ResponseEntity.ok(water_levelService.findAll());
        } catch (Exception e) {
            log.error("Error getting all Water_LevelModels", e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Water_LevelModel> getWaterLevel(@RequestParam("id") long id) throws Exception {
        try {
            log.info("Getting Water_LevelModel by id {}", id);
            return ResponseEntity.ok(water_levelService.findwaterlevelbyid(id).get());
        } catch (Exception e) {
            log.error("Error getting Water_LevelModel by id {}", id, e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWaterLevel(@RequestParam("id") long id) throws Exception {
        try {
            log.info("Deleting Water_LevelModel with id {}", id);
            water_levelService.delete(water_levelService.findwaterlevelbyid(id).get());
            return ResponseEntity.ok("Water_LevelModel deleted successfully");
        } catch (Exception e) {
            log.error("Error deleting Water_LevelModel with id {}", id, e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllWaterLevel() throws Exception {
        try {
            log.info("Deleting all Water_LevelModels");
            water_levelService.deleteAll();
            return ResponseEntity.ok("All Water_LevelModels deleted successfully");
        } catch (Exception e) {
            log.error("Error deleting all Water_LevelModels", e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }
}
