package com.example.weatherapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherAPIClient {
    @Value("${weather.api.key}")
    private String apiKey;
    @Value("${weather.api.url}")
    private  String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public Weather getWeatherData(String location) {
        String url = apiUrl + "?key=" + apiKey + "&q=" + location;
        // Make the API request
        WeatherApiResponse response = null;
            response = restTemplate.getForObject(url, WeatherApiResponse.class);
        // Convert the API response to your Weather entity
        if (response != null) {
            Weather weather = new Weather();
            weather.setLocation(location);
            weather.setTemp_C(response.getCurrent().getTemp_c());
            weather.setTemp_F(response.getCurrent().getTemp_f());

            // Set other weather attributes
            return weather;
        }
        return null;
    }
    // Implement methods to call the Weather API
}