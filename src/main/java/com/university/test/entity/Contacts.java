package com.university.test.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Contacts {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contacts_generator")
    @SequenceGenerator(name = "contacts_generator", sequenceName = "contacts_id_seq", allocationSize = 1)
    private Long id;
    private String phone;
    private String email;

}
