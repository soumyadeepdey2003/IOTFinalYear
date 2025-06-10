package com.trex.iot_backend.Controller;


import com.trex.iot_backend.Service.MQ2Service;
import com.trex.iot_backend.model.MQ2Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mq2")
@Slf4j
public class MQ2Controller {

    @Autowired
    private MQ2Service mq2Service;

    @PostMapping("/add")
    public ResponseEntity<MQ2Model> addMQ2(@RequestBody MQ2Model mq2Model) throws Exception {
        try {
            log.info("Saving MQ2Model {}", mq2Model);
            return ResponseEntity.ok(mq2Service.save(mq2Model));
        } catch (Exception e) {
            log.error("Error saving MQ2Model {}", mq2Model, e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MQ2Model> getMQ2(@PathVariable long id) throws Exception {
        try {
            log.info("Getting MQ2Model by id {}", id);
            return ResponseEntity.ok(mq2Service.findByIdmq2(id));
        } catch (Exception e) {
            log.error("Error getting MQ2Model by id {}", id, e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<MQ2Model>> getAllMQ2() throws Exception {
        try {
            log.info("Getting all MQ2Models");
            return ResponseEntity.ok(mq2Service.findAllMQ2Models());
        } catch (Exception e) {
            log.error("Error getting all MQ2Models", e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMQ2(@PathVariable long id) throws Exception {
        try {
            log.info("Deleting MQ2Model with id {}", id);
            mq2Service.deleteByIdmq2(id);
            return ResponseEntity.ok("MQ2Model deleted successfully");
        } catch (Exception e) {
            log.error("Error deleting MQ2Model with id {}", id, e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllMQ2() throws Exception {
        try {
            log.info("Deleting all MQ2Models");
            mq2Service.deleteAllmq2();
            return ResponseEntity.ok("All MQ2Models deleted successfully");
        } catch (Exception e) {
            log.error("Error deleting all MQ2Models", e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }


}
