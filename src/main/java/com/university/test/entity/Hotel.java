package com.university.test.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String phone;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Address address;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Contacts contacts;

    @ElementCollection
    @CollectionTable(name = "hotel_amenities", joinColumns = @JoinColumn(name = "hotel_id"))
    @Column(name = "amenity")
    private List<String> amenities;
}
