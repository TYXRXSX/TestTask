package com.university.test.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
public class ArrivalTime {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "arrival_time_generator")
    @SequenceGenerator(name = "arrival_time_generator", sequenceName = "arrival_time_id_seq", allocationSize = 1)
    private Long id;
    private String checkIn;
    private String checkOut;

}
