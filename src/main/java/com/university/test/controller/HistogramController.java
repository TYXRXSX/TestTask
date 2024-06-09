package com.university.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/property-view/")
public class HistogramController {

    @GetMapping("/histogram/{param}")
    public ResponseEntity<Map<String, Long>> getHotelsHistogram(@PathVariable String param) {
//        Map<String, Long> histogram = hotelService.getHotelsHistogram(param);
//        return ResponseEntity.ok(histogram);
        return null;
    }

    

}
