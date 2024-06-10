package com.university.test.service.impl;

import com.university.test.dto.DetailedHotelDTO;
import com.university.test.dto.PostHotelDTO;
import com.university.test.dto.SimpleHotelDTO;
import com.university.test.entity.Hotel;
import com.university.test.exception.ResourceNotFoundException;
import com.university.test.mapper.HotelMapper;
import com.university.test.repo.HotelRepo;
import com.university.test.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepo hotelRepo;
    private final HotelMapper hotelMapper;

    @Override
    public List<SimpleHotelDTO> getHotels() {
        return hotelRepo.findAll().stream().map(hotelMapper::hotelToSimpleHotelDTO).toList();
    }

    @Override
    public DetailedHotelDTO getHotelById(Long hotelId) {
        return hotelMapper.hotelToDetailedHotelDTO(hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel not found by id: %s".formatted(hotelId))));
    }

    @Override
    public SimpleHotelDTO postHotel(PostHotelDTO dto) {
        return hotelMapper.hotelToSimpleHotelDTO(hotelRepo.save(hotelMapper.PostHotelDTOToHotel(dto)));
    }

    @Override
    public void postHotelAmenities(List<String> amenities, Long hotelId) {
        Hotel hotel = hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel not found by id: %s".formatted(hotelId)));
        hotel.setAmenities(amenities);
        hotelRepo.save(hotel);
    }

    @Override
    public List<SimpleHotelDTO> searchHotels(String name, String brand, String city, String county, String amenities) {
        return hotelRepo.searchHotels(name, brand, city, county, amenities).stream().map(hotelMapper::hotelToSimpleHotelDTO).toList();
    }
}
