package com.university.test.service.impl;

import com.university.test.entity.Hotel;
import com.university.test.repo.HotelRepo;
import com.university.test.service.HistogramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HistogramServiceImpl implements HistogramService {

    private final HotelRepo hotelRepo;

    @Override
    public Map<String, Long> generateHistogram(String param) {
        Map<String, Long> histogram = new HashMap<>();

        switch (param) {
            case "brand":
                histogram = generateBrandHistogram();
                break;
            case "city":
                histogram = generateCityHistogram();
                break;
            case "county":
                histogram = generateCountyHistogram();
                break;
            case "amenities":
                histogram = generateAmenitiesHistogram();
                break;
            default:
                throw new IllegalArgumentException("Invalid parameter: " + param);
        }

        return histogram;
    }

    private Map<String, Long> generateBrandHistogram() {
        List<Hotel> hotels = hotelRepo.findAll();
        Map<String, Long> histogram = new HashMap<>();

        for (Hotel hotel : hotels) {
            String brand = hotel.getBrand();
            histogram.put(brand, histogram.getOrDefault(brand, 0L) + 1);
        }

        return histogram;
    }

    private Map<String, Long> generateCityHistogram() {
        List<Hotel> hotels = hotelRepo.findAll();
        Map<String, Long> histogram = new HashMap<>();

        for (Hotel hotel : hotels) {
            String city = hotel.getAddress().getCity();
            histogram.put(city, histogram.getOrDefault(city, 0L) + 1);
        }

        return histogram;
    }

    private Map<String, Long> generateCountyHistogram() {
        List<Hotel> hotels = hotelRepo.findAll();
        Map<String, Long> histogram = new HashMap<>();

        for (Hotel hotel : hotels) {
            String country = hotel.getAddress().getCounty();
            histogram.put(country, histogram.getOrDefault(country, 0L) + 1);
        }

        return histogram;
    }

    private Map<String, Long> generateAmenitiesHistogram() {
        List<Hotel> hotels = hotelRepo.findAll();
        Map<String, Long> histogram = new HashMap<>();

        for (Hotel hotel : hotels) {
            hotel.getAmenities().forEach(x->{
                histogram.put(x, histogram.getOrDefault(x, 0L) + 1);
            });
        }

        return histogram;
    }
}

