package com.trex.iot_backend.Controller;


import com.trex.iot_backend.Service.MQ135Service;
import com.trex.iot_backend.model.MQ135Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mq135")
@Slf4j
public class MQ135Controller {

    @Autowired
    private MQ135Service mq135Service;

    @PostMapping("/add")
    public ResponseEntity<MQ135Model> addMQ135(@RequestBody MQ135Model mq135Model) throws Exception {
        try {
            log.info("Saving MQ135Model {}", mq135Model);
            return ResponseEntity.ok(mq135Service.save(mq135Model));
        } catch (Exception e) {
            log.error("Error saving MQ135Model {}", mq135Model, e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<MQ135Model>> getAllMQ135() throws Exception {
        try {
            log.info("Getting all MQ135Models");
            return ResponseEntity.ok(mq135Service.findAllMQ135Models());
        } catch (Exception e) {
            log.error("Error getting all MQ135Models", e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MQ135Model> getMQ135(@PathVariable long id) throws Exception {
        try {
            log.info("Getting MQ135Model by id {}", id);
            return ResponseEntity.ok(mq135Service.findByIdmq135(id));
        } catch (Exception e) {
            log.error("Error getting MQ135Model by id {}", id, e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMQ135(@PathVariable long id) throws Exception {
        try {
            log.info("Deleting MQ135Model with id {}", id);
            mq135Service.deleteByIdmq135(id);
            return ResponseEntity.ok("MQ135Model deleted successfully");
        } catch (Exception e) {
            log.error("Error deleting MQ135Model with id {}", id, e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }
}
