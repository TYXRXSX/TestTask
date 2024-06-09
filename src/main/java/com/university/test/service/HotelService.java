package com.university.test.service;

import com.university.test.dto.DetailedHotelDTO;
import com.university.test.dto.PostHotelDTO;
import com.university.test.dto.SimpleHotelDTO;

import java.util.List;

public interface HotelService {

    List<SimpleHotelDTO> getHotels();

    DetailedHotelDTO getHotelById(Long hotelId);

    SimpleHotelDTO postHotel(PostHotelDTO dto);

    void postHotelAmenities(List<String> amenities);
}
