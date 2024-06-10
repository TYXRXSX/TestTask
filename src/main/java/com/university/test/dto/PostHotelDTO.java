package com.university.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class PostHotelDTO {

    private String name;
    private String description;
    private String brand;

    private AddressDTO address;

    private ContactsDTO contacts;

    private ArrivalTimeDTO arrivalTime;

}
