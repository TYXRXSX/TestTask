package com.university.test.controller;

import com.university.test.service.HistogramService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/property-view/")
@RequiredArgsConstructor
public class HistogramController {

    private final HistogramService histogramService;

    @GetMapping("/histogram/{param}")
    public Map<String, Long> getHotelsHistogram(@PathVariable String param) {
        return histogramService.generateHistogram(param);
    }


}
