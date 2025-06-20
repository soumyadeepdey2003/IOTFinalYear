package com.trex.iot_backend.model;


import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime date;
    private double water_level;
    private String location;

    public Water_LevelModel(LocalDateTime date, double water_level, String location) {
        this.date = date;
        this.water_level = water_level;
        this.location = location;
    }

}
