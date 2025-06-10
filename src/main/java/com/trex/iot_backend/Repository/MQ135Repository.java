package com.trex.iot_backend.Repository;

import com.trex.iot_backend.model.MQ135Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MQ135Repository extends JpaRepository<MQ135Model, Long> {
}
