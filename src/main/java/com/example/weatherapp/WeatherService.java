package com.example.weatherapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherService {
    private final WeatherRepository weatherRepository;
    private final WeatherAPIClient weatherAPIClient;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository, WeatherAPIClient weatherAPIClient) {
        this.weatherRepository = weatherRepository;
        this.weatherAPIClient = weatherAPIClient;
    }

    public Weather getWeatherByLocation(String location) {
        // Check if weather data is already in the local database
        Optional<Weather> optionalWeather = weatherRepository.findById(location);

        // If not, fetch data from the Weather API
        if (optionalWeather.isEmpty()) {
            // You need to implement this method in WeatherAPIClient
            // It should handle the API request and return the Weather object
            Weather weather = weatherAPIClient.getWeatherData(location);

            // Save the retrieved data to the local database
            weatherRepository.save(weather);

            return weather;
        }

        return optionalWeather.get();
    }
    public void updateWeatherByLocation(String location){
        weatherRepository.save(weatherAPIClient.getWeatherData(location));
    }
    // Implement methods to interact with the repository and call the weather API
}
