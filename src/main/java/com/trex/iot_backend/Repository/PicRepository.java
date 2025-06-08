package com.trex.iot_backend.Repository;

import com.trex.iot_backend.model.PicModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PicRepository extends JpaRepository<PicModel, Long> {
}
