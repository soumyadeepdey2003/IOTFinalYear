package com.trex.iot_backend.Service;


import com.trex.iot_backend.Repository.LdrRepository;
import com.trex.iot_backend.model.LdrModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LdrService {

    @Autowired
    private  LdrRepository ldrRepository;

    public LdrModel save(LdrModel ldrModel) throws Exception {
        log.info("save ldr");
        try {
            LocalDateTime now = LocalDateTime.now();
            ldrModel.setDate(now);
            return ldrRepository.save(ldrModel);
        } catch (Exception e) {
            log.error("Error saving LdrModel {}", ldrModel, e);
            throw new Exception("Error saving LdrModel");
        }

    }

    public String deleteAllldr() throws Exception {
        try {
            log.info("delete all ldr");
            ldrRepository.deleteAll();
        } catch (Exception e) {
            log.error("Error deleting all LdrModels", e);
            throw new Exception("Error deleting all LdrModels");
        }
    }

    public String deleteldr(long id) throws Exception {
        try {
            log.info("delete ldr");
            ldrRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error deleting LdrModel with ID {}", id, e);
            throw new Exception("Error deleting LdrModel: " + e.getMessage());
        }
    }

    public List<LdrModel> findAllldr() throws Exception {
        log.info("Finding all LdrModels");
        try {
            List<LdrModel> ldrModels = ldrRepository.findAll();
            return ldrModels;
        } catch (Exception e) {
            log.error("Error finding LdrModels", e);
            throw new Exception("Error finding LdrModels");
        }
    }

    public LdrModel findByIdldr(long id) throws Exception {
        log.info("Finding LdrModel by ID: {}", id);
        try {
            return ldrRepository.findById(id).orElseThrow(() -> new Exception("LdrModel not found with ID: " + id));
        } catch (Exception e) {
            log.error("Error finding LdrModel by ID: {}", id, e);
            throw new Exception("Error finding LdrModel: " + e.getMessage());
        }
    }
}
