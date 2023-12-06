package com.example.weatherapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WeatherApiResponseTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testWeatherApiResponseEqualsAndHashCode() {
        WeatherApiResponse.CurrentWeather currentWeather1 = new WeatherApiResponse.CurrentWeather();
        currentWeather1.setTemp_c("25");
        currentWeather1.setTemp_f("77");

        WeatherApiResponse.CurrentWeather currentWeather2 = new WeatherApiResponse.CurrentWeather();
        currentWeather2.setTemp_c("25");
        currentWeather2.setTemp_f("77");

        WeatherApiResponse weatherApiResponse1 = new WeatherApiResponse();
        weatherApiResponse1.setCurrent(currentWeather1);

        WeatherApiResponse weatherApiResponse2 = new WeatherApiResponse();
        weatherApiResponse2.setCurrent(currentWeather2);

        assertThat(weatherApiResponse1).isEqualTo(weatherApiResponse2);
        assertThat(weatherApiResponse1.hashCode()).isEqualTo(weatherApiResponse2.hashCode());
    }

    @Test
    void testWeatherApiResponseGettersAndSetters() {
        WeatherApiResponse.CurrentWeather currentWeather = new WeatherApiResponse.CurrentWeather();
        currentWeather.setTemp_c("25");
        currentWeather.setTemp_f("77");

        WeatherApiResponse weatherApiResponse = new WeatherApiResponse();
        weatherApiResponse.setCurrent(currentWeather);

        assertThat(weatherApiResponse.getCurrent()).isEqualTo(currentWeather);
    }

    @Test
    void testWeatherApiResponseJsonDeserialization() throws Exception {
        String json = "{\"current\":{\"temp_c\":\"25\",\"temp_f\":\"77\"}}";

        WeatherApiResponse weatherApiResponse = objectMapper.readValue(json, WeatherApiResponse.class);

        assertThat(weatherApiResponse).isNotNull();
        assertThat(weatherApiResponse.getCurrent()).isNotNull();
        assertThat(weatherApiResponse.getCurrent().getTemp_c()).isEqualTo("25");
        assertThat(weatherApiResponse.getCurrent().getTemp_f()).isEqualTo("77");
    }

    @Test
    void testWeatherApiResponseJsonDeserialization_InvalidJson() {
        String invalidJson = "{\"current\":{\"temp_c\":\"25\",\"temp_f\":\"77\"";

        assertThrows(Exception.class, () -> objectMapper.readValue(invalidJson, WeatherApiResponse.class));
    }
}

