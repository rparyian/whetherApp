package com.example.weatherapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherApiResponse {
    private CurrentWeather current;
    @Data
    public static class CurrentWeather {
        private String temp_c;
        private String temp_f;
        // Getters and setters
    }

}
