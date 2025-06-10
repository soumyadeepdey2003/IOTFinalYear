package com.trex.iot_backend.Service;

import com.trex.iot_backend.Repository.MQ135Repository;
import com.trex.iot_backend.model.MQ135Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MQ135Service {

    @Autowired
    private MQ135Repository mq135Repository;

    public MQ135Model save(MQ135Model mq135Model) throws Exception {
        try {
            LocalDateTime now = LocalDateTime.now();
            mq135Model.setDate(now);
            log.info("Saving MQ135Model {}", mq135Model);
            return mq135Repository.save(mq135Model);
        }
        catch (Exception e) {
            log.error("Error saving MQ135Model {}", mq135Model, e);
            throw new Exception("Error saving MQ135Model: " + e.getMessage());
        }
    }

    public String deleteAllmq135() throws Exception {
        try {
            mq135Repository.deleteAll();
            return "All MQ135Models deleted successfully";
        }
        catch (Exception e) {
            log.error("Error deleting all MQ135Models", e);
            throw new Exception("Error deleting all MQ135Models: " + e.getMessage());
        }
    }

    public String deleteByIdmq135(Long id) throws Exception {
        try {
            mq135Repository.deleteById(id);
            return "MQ135Model deleted successfully";
        }
        catch (Exception e) {
            log.error("Error deleting MQ135Model with ID {}", id, e);
            throw new Exception("Error deleting MQ135Model: " + e.getMessage());
        }
    }

    public MQ135Model findByIdmq135(Long id) throws Exception {
        log.info("Finding MQ135Model by ID: {}", id);
        try {
            return mq135Repository.findById(id).orElseThrow(() -> new Exception("MQ135Model not found with ID: " + id));
        }
        catch (Exception e) {
            log.error("Error finding MQ135Model by ID: {}", id, e);
            throw new Exception("Error finding MQ135Model: " + e.getMessage());
        }
    }

    public List<MQ135Model> findAllMQ135Models() throws Exception {
        try {
            List<MQ135Model> mq135Models = mq135Repository.findAll();
            log.info("Found {} MQ135Models", mq135Models.size());
            return mq135Models;
        } catch (Exception e) {
            log.error("Error finding MQ135Models", e);
            throw new Exception("Error finding MQ135Models");
        }

    }
}
