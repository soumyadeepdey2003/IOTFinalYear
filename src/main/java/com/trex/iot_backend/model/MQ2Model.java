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
@Table(name = "mq2")
@NoArgsConstructor
@Async
public class MQ2Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double methane;
    private double LPG;
    private LocalDateTime date;

    public MQ2Model(double methane, double LPG, LocalDateTime date) {
        this.methane = methane;
        this.LPG = LPG;
        this.date = date;
    }
}
