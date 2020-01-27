package com.wroclawhelperf.service;

import com.wroclawhelperf.domain.BikeStation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceTests {

    @Autowired
    private BikeService bikeService;

    @Test
    void testGetAllBikesStations() {
        for (BikeStation bikeStation : bikeService.getAllBikeStations()) {
            System.out.println(bikeStation);
        }
    }

    @Test
    void testGetBikesStation() {
        System.out.println(bikeService.getBikeStation(12497910L));
    }
}
