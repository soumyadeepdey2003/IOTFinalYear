package com.trex.iot_backend.Controller;


import com.trex.iot_backend.Service.DHTService;
import com.trex.iot_backend.model.DHTModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dht")
@Slf4j
public class DHTController {

    @Autowired
    private DHTService dhtService;

    @PostMapping("/add")
    public ResponseEntity<DHTModel> AddDHT(@RequestBody DHTModel dhtModel)throws Exception {
        try {
            log.info("Saving DHTModel {}", dhtModel);
            return ResponseEntity.ok(dhtService.save(dhtModel));
        } catch (Exception e) {
            log.error("Error saving DHTModel {}", dhtModel, e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DHTModel> GetDHT(@PathVariable long id)throws Exception {
        try {
            log.info("Getting all DHTModels");
            return ResponseEntity.ok(dhtService.finddhtbyid(id).get());
        } catch (Exception e) {
            log.error("Error getting all DHTModels", e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeleteDHT(@PathVariable long id) throws Exception {
        try {
            log.info("Deleting DHTModel with id {}", id);
            dhtService.delete(dhtService.finddhtbyid(id).get());
            return ResponseEntity.ok("DHTModel deleted successfully");
        } catch (Exception e) {
            log.error("Error deleting DHTModel with id {}", id, e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> DeleteAllDHT() throws Exception {
        try {
            log.info("Deleting all DHTModels");
            dhtService.deleteAll();
            return ResponseEntity.ok("All DHTModels deleted successfully");
        } catch (Exception e) {
            log.error("Error deleting all DHTModels", e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DHTModel>> GetAllDHT()throws Exception
    {
        try {
            log.info("Getting all DHTModels");
            return ResponseEntity.ok(dhtService.findAll());
        }
        catch (Exception e) {
            log.error("Error getting all DHTModels", e);
            throw new RuntimeException(ResponseEntity.badRequest().body(e.getMessage()).toString());
        }
    }

}
