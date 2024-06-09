package com.university.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ArrivalTimeDTO {

    private String checkIn;
    private String checkOut;

    public ArrivalTimeDTO(String checkIn, String checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
}
