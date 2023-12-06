package com.example.weatherapp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WeatherTest {

    @Test
    void testWeatherGettersAndSetters() {
        Weather weather = new Weather();

        // Set values using setters
        weather.setLocation("TestLocation");
        weather.setTemp_C("25");

        // Check values using getters
        assertThat(weather.getLocation()).isEqualTo("TestLocation");
        assertThat(weather.getTemp_C()).isEqualTo("25");
    }

    @Test
    void testWeatherEqualsAndHashCode() {
        Weather weather1 = new Weather("Location1", "25", "33");
        Weather weather2 = new Weather("Location1", "25", "33");
        Weather weather3 = new Weather("Location2", "30", "46");

        // Equals and hashCode should consider only the 'location' attribute
        assertThat(weather1).isEqualTo(weather2);
        assertThat(weather1.hashCode()).isEqualTo(weather2.hashCode());
        assertThat(weather1).isNotEqualTo(weather3);
        assertThat(weather1.hashCode()).isNotEqualTo(weather3.hashCode());
    }

    @Test
    void testWeatherConstructors() {
        // Test no-arg constructor
        Weather weather1 = new Weather();
        assertThat(weather1.getLocation()).isNull();
        assertThat(weather1.getTemp_C()).isNull();

        // Test parameterized constructor
        Weather weather2 = new Weather("Location", "25", "34");
        assertThat(weather2.getLocation()).isEqualTo("Location");
        assertThat(weather2.getTemp_C()).isEqualTo("25");
    }
}
