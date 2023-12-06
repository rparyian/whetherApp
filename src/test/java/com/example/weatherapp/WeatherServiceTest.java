package com.example.weatherapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WeatherServiceTest {

    @Mock
    private WeatherRepository weatherRepository;

    @Mock
    private WeatherAPIClient weatherAPIClient;

    @InjectMocks
    private WeatherService weatherService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetWeatherByLocation_ExistingLocation() {
        String location = "testLocation";
        Weather mockWeather = new Weather();
        mockWeather.setLocation(location);
        mockWeather.setTemp_C("20");

        when(weatherRepository.findById(location)).thenReturn(Optional.of(mockWeather));

        Weather result = weatherService.getWeatherByLocation(location);

        verify(weatherRepository, times(1)).findById(location);
        verify(weatherAPIClient, never()).getWeatherData(anyString());
        assertEquals(mockWeather, result);
    }

    @Test
    void testGetWeatherByLocation_NonExistingLocation() {
        String location = "nonExistingLocation";
        Weather mockWeatherFromAPI = new Weather();
        mockWeatherFromAPI.setLocation(location);
        mockWeatherFromAPI.setTemp_C("25");

        when(weatherRepository.findById(location)).thenReturn(Optional.empty());
        when(weatherAPIClient.getWeatherData(location)).thenReturn(mockWeatherFromAPI);
        when(weatherRepository.save(mockWeatherFromAPI)).thenReturn(mockWeatherFromAPI);

        Weather result = weatherService.getWeatherByLocation(location);

        verify(weatherRepository, times(1)).findById(location);
        verify(weatherAPIClient, times(1)).getWeatherData(location);
        verify(weatherRepository, times(1)).save(mockWeatherFromAPI);
        assertEquals(mockWeatherFromAPI, result);
    }
}
