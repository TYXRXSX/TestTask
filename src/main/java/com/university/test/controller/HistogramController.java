package com.university.test.controller;

import com.university.test.service.HistogramService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Histogram", description = "Histogram API")
public class HistogramController {

    private final HistogramService histogramService;


    @Operation(
            summary = "Gets histogram of all hotels by parameter",
            description = "Gets histogram of all hotels by parameter",
            tags = { "tutorials", "get" })
    @GetMapping("/histogram/{param}")
    public Map<String, Long> getHotelsHistogram(@PathVariable String param) {
        return histogramService.generateHistogram(param);
    }


}
