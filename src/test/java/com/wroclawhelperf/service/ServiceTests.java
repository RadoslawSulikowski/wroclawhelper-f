package com.wroclawhelperf.service;

import com.wroclawhelperf.domain.GPSLocation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceTests {

    @Autowired
    private BikeService bikeService;

    @Autowired
    private WeatherStationService weatherStationService;

    @Autowired
    private WeatherService weatherService;

    @Test
    void testGetAllBikesStations() {
        bikeService.getAllBikeStations().forEach(System.out::println);
    }

    @Test
    void testGetBikesStation() {
        System.out.println(bikeService.getBikeStation(12497910L));
    }

    @Test
    void testGetBikesStationNearestLocation() {
        System.out.println(bikeService.getBikeStationNearestLocation(
                new GPSLocation(51.138235, 16.973045)));
    }

    @Test
    void testGetBikesStationNearestUser() {
        System.out.println(bikeService.getBikeStationNearestFromUser(8L));
    }

    @Test
    void testGetWeatherStations() {
        weatherStationService.getWeatherStations().forEach(System.out::println);
    }

    @Test
    void testGetWeatherStation() {
        System.out.println(weatherService.getWeatherOnStation("MILENIJNY"));

    }
}
