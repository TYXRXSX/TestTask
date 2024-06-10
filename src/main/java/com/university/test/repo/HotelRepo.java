package com.university.test.repo;

import com.university.test.dto.DetailedHotelDTO;
import com.university.test.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HotelRepo extends JpaRepository<Hotel, Integer> {
    Optional<Hotel> findById(Long hotelId);

    @Query("SELECT h FROM Hotel h WHERE (:name IS NULL OR h.name = :name) " +
            "AND (:brand IS NULL OR h.brand = :brand) " +
            "AND (:city IS NULL OR h.address.city = :city) " +
            "AND (:county IS NULL OR h.address.county = :county) " +
            "AND (:amenities IS NULL OR :amenities MEMBER OF h.amenities)")
    List<Hotel> searchHotels(@Param("name") String name,
                             @Param("brand") String brand,
                             @Param("city") String city,
                             @Param("county") String county,
                             @Param("amenities") String amenities);
}
