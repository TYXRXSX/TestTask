package com.university.test.controller;

import com.university.test.dto.DetailedHotelDTO;
import com.university.test.dto.PostHotelDTO;
import com.university.test.dto.SimpleHotelDTO;
import com.university.test.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property-view/")
@RequiredArgsConstructor
@Tag(name = "Hotel", description = "Hotel API")
public class HotelController {


    private final HotelService hotelService;

    @Operation(
            summary = "Retrieve all hotels",
            description = "Retrieve all hotels, uses simple version of hotelDTO",
            tags = { "tutorials", "get" })
    @GetMapping("/hotels")
    public List<SimpleHotelDTO> getAllHotels() {
        return hotelService.getHotels();
    }

    @Operation(
            summary = "Retrieve hotel by ID",
            description = "Retrieve hotel by ID, uses detailed version of hotelDTO",
            tags = { "tutorials", "get" })
    @GetMapping("/hotels/{id}")
    public DetailedHotelDTO getHotelById(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    @Operation(
            summary = "Posts Hotel",
            description = "Serves to post hotel, uses detailed hotelDTO",
            tags = { "tutorials", "post" })
    @PostMapping("/hotels")
    public SimpleHotelDTO postHotel(@RequestBody PostHotelDTO hotelDto) {
        return hotelService.postHotel(hotelDto);
    }

    @Operation(
            summary = "Post hotels amenities",
            description = "Posts hotels amenities",
            tags = { "tutorials", "post" })
    @PostMapping("/hotels/{id}/amenities")
    public void postHotelAmenities(@RequestBody List<String> amenities, @PathVariable Long id) {
        hotelService.postHotelAmenities(amenities, id);
    }

    @Operation(
            summary = "Search hotel via param and it's value, displays hotels with simplified version of Hotel DTO",
            description = "",
            tags = { "tutorials", "get" })
    @GetMapping("/search")
    public List<SimpleHotelDTO> searchHotels(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String county,
            @RequestParam(required = false) String amenities
    ) {
        return hotelService.searchHotels(name, brand, city, county, amenities);
    }
}
