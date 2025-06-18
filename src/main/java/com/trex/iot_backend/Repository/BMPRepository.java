package com.trex.iot_backend.Repository;

import com.trex.iot_backend.model.BMPModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BMPRepository extends JpaRepository<BMPModel, Long> {
}
