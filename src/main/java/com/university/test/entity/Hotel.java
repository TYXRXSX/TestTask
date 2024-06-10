package com.university.test.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_generator")
    @SequenceGenerator(name = "hotel_generator", sequenceName = "hotel_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String brand;
    private String description;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Contacts contacts;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrivalTime arrivalTime;

    @ElementCollection
    @CollectionTable(name = "hotel_amenities", joinColumns = @JoinColumn(name = "hotel_id"))
    @Column(name = "amenity")
    private List<String> amenities;
}
