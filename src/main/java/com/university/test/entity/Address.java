package com.university.test.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_generator")
    @SequenceGenerator(name = "address_generator", sequenceName = "address_id_seq", allocationSize = 1)
    private Long id;
    private String houseNumber;
    private String street;
    private String city;
    private String county;
    private String postCode;

}
