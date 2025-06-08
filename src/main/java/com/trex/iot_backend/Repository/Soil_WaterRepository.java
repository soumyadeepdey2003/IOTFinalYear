package com.trex.iot_backend.Repository;

import com.trex.iot_backend.model.Soil_waterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Soil_WaterRepository extends JpaRepository<Soil_waterModel, Long> {
}
