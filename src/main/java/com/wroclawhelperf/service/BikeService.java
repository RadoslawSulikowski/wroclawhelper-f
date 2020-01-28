package com.wroclawhelperf.service;

import com.wroclawhelperf.domain.BikeStation;
import com.wroclawhelperf.domain.GPSLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class BikeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BikeService.class);
    private RestTemplate restTemplate = new RestTemplate();
    private static BikeService bikeServiceInstance = null;

    //@Value("${api.source.root}")
    private String sourceRoot = "http://localhost:8080";


    public static BikeService getInstance() {
        if (bikeServiceInstance == null) {
            bikeServiceInstance = new BikeService();
        }
        return bikeServiceInstance;
    }

    private BikeService() {

    }

    public List<BikeStation> getAllBikeStations() {
        URI uriRequest = UriComponentsBuilder.fromHttpUrl(sourceRoot + "/bikes")
                .build().encode().toUri();
        return Arrays.asList(ofNullable(restTemplate.getForObject(uriRequest, BikeStation[].class))
                .orElse(new BikeStation[0]));
    }

    public BikeStation getBikeStation(Long stationId) {
        URI uriRequest = UriComponentsBuilder.fromHttpUrl(sourceRoot + "/bikes/" + stationId)
                .build().encode().toUri();
        return restTemplate.getForObject(uriRequest, BikeStation.class);
    }

    public BikeStation getBikeStationNearestFromUser(Long userId) {
        URI uriRequest = UriComponentsBuilder.fromHttpUrl(sourceRoot + "/bikes/user/" + userId)
                .build().encode().toUri();
        return restTemplate.getForObject(uriRequest, BikeStation.class);
    }

    public BikeStation getBikeStationNearestLocation(GPSLocation location) {
        RequestFactory requestFactory = new RequestFactory();
        RestTemplate restTemplate = requestFactory.getRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<BikeStation> responseEntity = restTemplate.exchange(sourceRoot + "/bikes/location", HttpMethod.GET,
                new HttpEntity<>(location, headers), BikeStation.class);
        return responseEntity.getBody();
    }


}
