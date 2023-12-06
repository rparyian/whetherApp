package com.example.weatherapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeatherDataScheduler {

    private final WeatherService weatherService;
    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherDataScheduler(WeatherService weatherService, WeatherRepository weatherRepository) {
        this.weatherService = weatherService;
        this.weatherRepository = weatherRepository;
    }

    // Run the scheduler every 10 minutes (600,000 milliseconds)
    @Scheduled(fixedRate = 600_000)
    public void updateWeatherData() {
        // Fetch the list of locations from the repository
        Iterable<Weather> weatherList = weatherRepository.findAll();

        for (Weather weather : weatherList) {
            // Update weather data for each location
            weatherService.updateWeatherByLocation(weather.getLocation());
        }
    }
}