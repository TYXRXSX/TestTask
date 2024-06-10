package com.university.test.controller;

import com.university.test.service.HistogramService;
import org.junit.Before;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
public class HistogramControllerTest {

    @Mock
    private HistogramService histogramService;

    @InjectMocks
    private HistogramController histogramController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(histogramController).build();
    }

    @Test
    public void testGetHotelsHistogram() throws Exception {
        Map<String, Long> histogramData = new HashMap<>();
        histogramData.put("category1", 10L);
        histogramData.put("category2", 5L);
        when(histogramService.generateHistogram("param")).thenReturn(histogramData);

        mockMvc.perform(get("/histogram/{param}", "param"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.category1").value(10))
                .andExpect(jsonPath("$.category2").value(5));

        verify(histogramService).generateHistogram("param");
    }
}