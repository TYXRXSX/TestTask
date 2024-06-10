package com.university.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ContactsDTO {
    private String phone;
    private String email;

    public ContactsDTO(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }
}
