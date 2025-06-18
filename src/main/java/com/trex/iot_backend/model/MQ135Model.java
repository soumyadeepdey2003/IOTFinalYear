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
@Table(name = "mq135")
@NoArgsConstructor
@Async
public class MQ135Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double co2;
    private double NH3;
    private String location;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    public MQ135Model(double co2, double NH3, LocalDateTime date, String location) {
        this.co2 = co2;
        this.NH3 = NH3;
        this.date = date;
        this.location = location;
    }
}
