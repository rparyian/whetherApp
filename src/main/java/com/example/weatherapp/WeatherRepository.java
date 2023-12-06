package com.example.weatherapp;

import org.springframework.data.repository.CrudRepository;

public interface WeatherRepository extends CrudRepository<Weather, String> {
    // Define custom queries if needed
}
