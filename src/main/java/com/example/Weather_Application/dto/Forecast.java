package com.example.Weather_Application.dto;

import java.util.List;

public class Forecast {
    private List<Forecastday> forecastday;

    public List<Forecastday> getForecastday() {
        return forecastday;
    }

    public void setForecastDay(List<Forecastday> forecastday) {
        this.forecastday = forecastday;
    }
}
