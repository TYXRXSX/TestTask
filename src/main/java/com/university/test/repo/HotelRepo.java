package com.university.test.repo;

import com.university.test.dto.DetailedHotelDTO;
import com.university.test.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepo extends JpaRepository<Hotel, Integer> {
    Optional<Hotel> findById(Long hotelId);
}
