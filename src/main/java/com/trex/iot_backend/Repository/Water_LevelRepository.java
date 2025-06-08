package com.trex.iot_backend.Repository;

import com.trex.iot_backend.model.Water_LevelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Water_LevelRepository extends JpaRepository<Water_LevelModel, Long> {
}
