package com.example.Weather_Application.dto;

public class WeatherResponse {
    private String city;
    private  String region;
    private String country;
    private Condition condition;
    private Double temperature;

    public WeatherResponse(String city, String region, String country, Condition condition, Double temperature) {
        this.city = city;
        this.region = region;
        this.country = country;
        this.condition = condition;
        this.temperature = temperature;
    }

    public WeatherResponse() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
