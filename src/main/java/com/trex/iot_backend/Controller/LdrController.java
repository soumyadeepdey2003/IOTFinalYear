package com.trex.iot_backend.Controller;


import com.trex.iot_backend.Service.LdrService;
import com.trex.iot_backend.model.LdrModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ldr")
@Slf4j
public class LdrController {

    @Autowired
    private LdrService ldrService;

    @GetMapping("/getAll")
    public ResponseEntity<List<LdrModel>> getAllLdr() throws Exception {

        log.info("Getting all LdrModels");
        try {
            return ResponseEntity.ok(ldrService.findAllldr());
        } catch (Exception e) {
            log.error("Error getting all LdrModels", e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<LdrModel> getLdr(@PathVariable long id) throws Exception {

        log.info("Getting LdrModel by id {}", id);
        try {
            return ResponseEntity.ok(ldrService.findByIdldr(id));
        } catch (Exception e) {
            log.error("Error getting LdrModel by id {}", id, e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<LdrModel> addLdr(@RequestBody LdrModel ldrModel) throws Exception {

        log.info("Saving LdrModel {}", ldrModel);
        try {
            return ResponseEntity.ok(ldrService.save(ldrModel));
        } catch (Exception e) {
            log.error("Error saving LdrModel {}", ldrModel, e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLdr(@PathVariable long id) throws Exception {

        log.info("Deleting LdrModel by id {}", id);
        try {
            return ResponseEntity.ok(ldrService.deleteldr(id));
        } catch (Exception e) {
            log.error("Error deleting LdrModel by id {}", id, e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllLdr() throws Exception {

        log.info("Deleting all LdrModels");
        try {
            return ResponseEntity.ok(ldrService.deleteAllldr());
        } catch (Exception e) {
            log.error("Error deleting all LdrModels", e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }
}
