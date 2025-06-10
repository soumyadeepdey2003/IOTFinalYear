package com.trex.iot_backend.Service;

import com.trex.iot_backend.Repository.MQ2Repository;
import com.trex.iot_backend.model.MQ2Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MQ2Service {
    @Autowired
    private MQ2Repository mq2Repository;

    public MQ2Model save(MQ2Model mq2Model) throws Exception {
        LocalDateTime now = LocalDateTime.now();
        try {
            mq2Model.setDate(now);
            log.info("Saving MQ2Model {}", mq2Model);
            return mq2Repository.save(mq2Model);
        } catch (Exception e) {
            log.error("Error saving MQ2Model {}", mq2Model, e);
            throw new Exception("Error saving MQ2Model");
        }
    }

    public List<MQ2Model> findAllMQ2Models() throws Exception {
        log.info("Finding all MQ2Models");
        try {
            List<MQ2Model> mq2Models = mq2Repository.findAll();
            return mq2Models;
        } catch (Exception e) {
            log.error("Error finding MQ2Models", e);
            throw new RuntimeException("Error finding MQ2Models");
        }
    }

    public MQ2Model findByIdmq2(Long id) throws Exception {
        log.info("Finding MQ2Model by ID: {}", id);
        try {
            return mq2Repository.findById(id).orElseThrow(() -> new Exception("MQ2Model not found with ID: " + id));
        } catch (Exception e) {
            log.error("Error finding MQ2Model by ID: {}", id, e);
            throw new Exception("Error finding MQ2Model: " + e.getMessage());
        }
    }
    public String deleteByIdmq2(Long id) throws Exception {
        try {
            mq2Repository.deleteById(id);
            return "MQ2Model deleted successfully";
        } catch (Exception e) {
            log.error("Error deleting MQ2Model with ID {}", id, e);
            throw new Exception("Error deleting MQ2Model: " + e.getMessage());
        }
    }

    public String deleteAllmq2() throws Exception {
        try {
            mq2Repository.deleteAll();
            return "All MQ2Models deleted successfully";
        } catch (Exception e) {
            log.error("Error deleting all MQ2Models", e);
            throw new Exception("Error deleting all MQ2Models: " + e.getMessage());
        }
    }



}
