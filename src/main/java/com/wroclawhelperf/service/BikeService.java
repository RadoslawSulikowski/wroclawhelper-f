package com.wroclawhelperf.service;

import com.wroclawhelperf.domain.BikeStation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class BikeService {

    @Value("${api.source.root}")
    private String sourceRoot;

    private RestTemplate restTemplate = new RestTemplate();
    private static BikeService bikeServiceInstance = null;

    public static BikeService getInstance() {
        if (bikeServiceInstance == null) {
            bikeServiceInstance = new BikeService();
        }
        return bikeServiceInstance;
    }

    private BikeService() {

    }

    private URI createGetAllStationsUri() {
        return UriComponentsBuilder.fromHttpUrl("http://localhost:8080/bikes")
                .build().encode().toUri();
    }

    private URI createGetStationByIdUri(Long stationId) {
        return UriComponentsBuilder.fromHttpUrl("http://localhost:8080/bikes/" + stationId)
                .build().encode().toUri();
    }

    public List<BikeStation> getAllBikeStations() {
        return Arrays.asList(ofNullable(restTemplate.getForObject(createGetAllStationsUri(), BikeStation[].class))
                .orElse(new BikeStation[0]));
    }

    public BikeStation getBikeStation(Long stationId) {
        return restTemplate.getForObject(createGetStationByIdUri(stationId), BikeStation.class);
    }


}
