package com.trex.iot_backend.Service;


import com.trex.iot_backend.Repository.BMPRepository;
import com.trex.iot_backend.model.BMPModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class BMPService {

    @Autowired
    private BMPRepository bmpRepository;

    public BMPModel save(BMPModel bmpModel) throws Exception {
        try{
            log.info("Saving BMPModel {}", bmpModel);
            return bmpRepository.save(bmpModel);
        }
        catch (Exception e){
            log.error("Error saving BMPModel {}", bmpModel, e);
            throw new Exception("Error saving BMPModel");
        }
    }

    public BMPModel findById(long id) throws Exception {
        try{
            log.info("Fetching BMPModel by id {}", id);
            return bmpRepository.findById(id).orElse(null);
        }
        catch (Exception e){
            log.error("Error fetching BMPModel by id {}", id, e);
            throw new Exception("Error fetching BMPModel by id");
        }
    }

    public List<BMPModel> findBmpAll() throws Exception {
        try{
            log.info("Fetching all BMPModels");
            List<BMPModel> bmpModels = bmpRepository.findAll();
            return bmpModels;
        }
        catch (Exception e){
            log.error("Error fetching all BMPModels", e);
            throw new Exception("Error fetching all BMPModels");
        }
    }

    public String deleteBmp(long id) throws Exception {
        try{
            log.info("Deleting BMPModel with id {}", id);
            bmpRepository.deleteById(id);
            return "BMPModel with id " + id + " deleted";
        }
        catch (Exception e){
            log.error("Error deleting BMPModel with id {}", id, e);
            throw new Exception("Error deleting BMPModel");
        }
    }

    public String deleteAllBmp() throws Exception {
        try{
            log.info("Deleting all BMPModels");
            bmpRepository.deleteAll();
            return "All BMPModels deleted";
        }
        catch (Exception e){
            log.error("Error deleting all BMPModels", e);
            throw new Exception("Error deleting all BMPModels");
        }
    }
}
