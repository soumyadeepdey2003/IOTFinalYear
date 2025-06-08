package com.trex.iot_backend.Service;


import com.trex.iot_backend.Repository.Water_LevelRepository;
import com.trex.iot_backend.model.Water_LevelModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class Water_LevelService {

    @Autowired
    private Water_LevelRepository waterLevelRepository;

    public Water_LevelModel save(Water_LevelModel waterLevelModel) throws Exception {
        LocalDateTime now = LocalDateTime.now();
        waterLevelModel.setDate(now);
        log.info("Saving WaterLevelModel {}", waterLevelModel);
        try {
            return waterLevelRepository.save(waterLevelModel);
        } catch (Exception e) {
            log.error("Error saving WaterLevelModel {}", waterLevelModel, e);
            throw new Exception("Error saving WaterLevelModel");
        }
    }

    public List<Water_LevelModel> findAll() throws Exception {
        log.info("Finding all WaterLevelModels");
        try {
            List<Water_LevelModel> waterLevelModels = waterLevelRepository.findAll();
            return waterLevelModels;
        } catch (Exception e) {
            log.error("Error finding WaterLevelModels", e);
            throw new Exception("Error finding WaterLevelModels");
        }
    }

    public void deleteAll()throws Exception {
        log.info("Deleting all WaterLevelModels");
        try {
            waterLevelRepository.deleteAll();
        } catch (Exception e) {
            log.error("Error deleting all WaterLevelModels", e);
            throw new Exception("Error deleting all WaterLevelModels");
        }

    }

    public void delete(Water_LevelModel waterLevelModel) throws Exception {
        log.info("Deleting WaterLevelModel {}", waterLevelModel);
        try {
            waterLevelRepository.delete(waterLevelModel);
        } catch (Exception e) {
            log.error("Error deleting WaterLevelModel {}", waterLevelModel, e);
            throw new Exception("Error deleting WaterLevelModel");
        }
    }

    public Optional<Water_LevelModel> findwaterlevelbyid(long id) throws Exception {
        Optional<Water_LevelModel> waterLevelModel = waterLevelRepository.findById(id);

        if (waterLevelModel.isPresent()) {
            log.info("Found WaterLevelModel by id {}", id);
            return waterLevelModel;
        } else {
            log.warn("WaterLevelModel not found for id {}", id);
            throw new Exception("WaterLevelModel not found");
        }
    }


}
