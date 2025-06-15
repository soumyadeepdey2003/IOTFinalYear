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
@Table(name = "ph")
@NoArgsConstructor
@Async
public class PHModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private LocalDateTime date;
    private String location;
    private double ph;

    public PHModel(LocalDateTime date, double ph, String location) {
        this.date = date;
        this.ph = ph;
        this.location = location;
    }

}
