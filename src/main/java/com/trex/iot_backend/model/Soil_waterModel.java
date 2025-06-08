package com.trex.iot_backend.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

import java.time.LocalDateTime;

@Data
@Slf4j
@Entity
@Getter
@Setter
@Table(name = "soil_water")
@NoArgsConstructor
@Async
public class Soil_waterModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private double soil_water;

    public Soil_waterModel(LocalDateTime date, double soil_water) {
        this.date = date;
        this.soil_water = soil_water;
    }



}
