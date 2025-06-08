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
@Table(name = "water_level")
@NoArgsConstructor
@Async
public class Water_LevelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;
    private double water_level;

    public Water_LevelModel(LocalDateTime date, double water_level) {
        this.date = date;
        this.water_level = water_level;
    }

}
