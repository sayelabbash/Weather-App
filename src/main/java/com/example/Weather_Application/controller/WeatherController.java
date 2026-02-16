package com.example.Weather_Application.controller;

import com.example.Weather_Application.dto.WeatherForcast;
import com.example.Weather_Application.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/forecast")
    public WeatherForcast getForeCast(@RequestParam String city,@RequestParam int days){
        return weatherService.getforcast(city,days);
    }

}
