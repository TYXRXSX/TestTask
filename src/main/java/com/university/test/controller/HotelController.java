package com.university.test.controller;

import com.university.test.dto.DetailedHotelDTO;
import com.university.test.dto.PostHotelDTO;
import com.university.test.dto.SimpleHotelDTO;
import com.university.test.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property-view/")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotels")
    public List<SimpleHotelDTO> getAllHotels() {
        return hotelService.getHotels();
    }

    @GetMapping("/hotels/{id}")
    public DetailedHotelDTO getHotelById(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    @PostMapping("/hotels")
    public SimpleHotelDTO postHotel(@RequestBody PostHotelDTO hotelDto) {
        return hotelService.postHotel(hotelDto);
    }

    @PostMapping("/hotels/{id}/amenities")
    public void postHotelAmenities(@RequestBody List<String> amenities, @PathVariable Long id) {
        hotelService.postHotelAmenities(amenities);
    }

    @GetMapping("/search")
    public List<SimpleHotelDTO> searchHotels(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String county,
            @RequestParam(required = false) String amenities
    ) {
        return null;
    }
}
