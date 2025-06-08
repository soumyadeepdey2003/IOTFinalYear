package com.trex.iot_backend.Repository;

import com.trex.iot_backend.model.PHModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PHRepository extends JpaRepository<PHModel, Long> {
}
