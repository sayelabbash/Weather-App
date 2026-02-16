package com.example.Weather_Application.service;

import com.example.Weather_Application.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String apiKey;
    @Value("${weather.api.current.url}")
    private String currentUrl;
    @Value("${weather.api.forecast.url}")
    private String forecastUrl;

    private RestTemplate template = new RestTemplate();

    public WeatherResponse getCurrentData(String city){
        String url =currentUrl+"?key="+apiKey+"&q="+city;

        Root response =template.getForObject(url, Root.class);

        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setCity(response.getLocation().getName());
        weatherResponse.setRegion(response.getLocation().getRegion());
        weatherResponse.setCountry(response.getLocation().getCountry());
        weatherResponse.setCondition(response.getCurrent().getCondition());
        weatherResponse.setTemperature(response.getCurrent().getTemp_c());

        return weatherResponse;
    }

    public WeatherForcast getforcast(String city,int days){
        String url =forecastUrl+"?key="+apiKey+"&q="+city+"&days="+days;
        Root response=template.getForObject(url, Root.class);
        WeatherForcast forcast = new WeatherForcast();
        WeatherResponse weatherResponse =getCurrentData(city);
        forcast.setWeatherResponse(weatherResponse);
        List<DayTemp> dayList = new ArrayList<>();
        for(Forecastday f:response.getForecast().getForecastday()){
            DayTemp d = new DayTemp();
            d.setDate(f.getDate());
            d.setMinTemp(f.getDay().getMintemp_c());
            d.setAvgTemp(f.getDay().getAvgtemp_c());
            d.setMaxTemp(f.getDay().getMaxtemp_c());
            dayList.add(d);
        }
        forcast.setDayTemp(dayList);
        return forcast;
    }

}
