package com.wroclawhelperf.service;

import com.wroclawhelperf.domain.GPSLocation;
import com.wroclawhelperf.domain.User;
import com.wroclawhelperf.domain.UserToVerify;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceTests {
//
    @Autowired
    private BikeService bikeService;

    @Autowired
    private WeatherStationService weatherStationService;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @Test
    void testUpdateUser() {
        User user = new User(
                "c",
                "c",
                "a",
                "c",
                "c",
                new GPSLocation(52,17),
                false
        );
        System.out.println(userService.updateUser(user));
    }
//    @Test
//    void testGetUserByUsername() {
//        System.out.println(userService.getUserByUsername("a"));
//    }
//
//    @Test
//    void testVerifyUser() {
//        System.out.println(userService.verifyUser(new UserToVerify("a","b")));
//    }

//    @Test
//    void testGetAllBikesStations() {
//        bikeService.getAllBikeStations().forEach(System.out::println);
//    }
//
//    @Test
//    void testGetBikesStation() {
//        System.out.println(bikeService.getBikeStation(12497910L));
//    }
//
//    @Test
//    void testGetBikesStationNearestLocation() {
//        System.out.println(bikeService.getBikeStationNearestLocation(
//                new GPSLocation(51.138235, 16.973045)));
//    }
//
//    @Test
//    void testGetBikesStationNearestUser() {
//        System.out.println(bikeService.getBikeStationNearestFromUser(17L));
//    }
//
//    @Test
//    void testGetWeatherStations() {
//        weatherStationService.getWeatherStations().forEach(System.out::println);
//    }
//
//    @Test
//    void testGetWeatherStation() {
//        System.out.println(weatherService.getWeatherOnStation("MILENIJNY"));
//    }
//
//    @Test
//    void testGetAllCars() {
//       carService.getAllCars().forEach(System.out::println);
//    }
//
//    @Test
//    void testFindNearestCar() {
//        System.out.println(carService.getNearestCarFromLocation(new GPSLocation(51.138235, 16.973045)));
//    }
}
