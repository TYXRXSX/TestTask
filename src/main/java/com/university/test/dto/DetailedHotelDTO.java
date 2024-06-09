package com.university.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailedHotelDTO {

    private Long id;
    private String name;
    private String brand;

    private AddressDTO address;

    private ContactsDTO contacts;

    private ArrivalTimeDTO arrivalTimeDTO;

    private List<String> amenities;

}
