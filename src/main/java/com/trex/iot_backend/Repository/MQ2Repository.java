package com.trex.iot_backend.Repository;

import com.trex.iot_backend.model.MQ2Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MQ2Repository extends JpaRepository<MQ2Model, Long> {
}
