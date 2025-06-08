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
@Table(name = "ph")
@NoArgsConstructor
@Async
public class PHModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime date;
    private double ph;

    public PHModel(LocalDateTime date, double ph) {
        this.date = date;
        this.ph = ph;
    }

}
