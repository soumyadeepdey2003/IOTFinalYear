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
@Table(name = "dht")
@NoArgsConstructor
@Async
public class DHTModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double temperature;
    private double humidity;
    private LocalDateTime date;

    public DHTModel(double temperature, double humidity, LocalDateTime date) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.date = date;
    }
}
