package com.wroclawhelperf.service;

import com.wroclawhelperf.config.Config;
import com.wroclawhelperf.domain.GPSLocation;
import com.wroclawhelperf.domain.VozillaCar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class CarService {

    private final Logger LOGGER = LoggerFactory.getLogger(CarService.class);

    private final String sourceRoot = Config.SOURCE_ROOT;
    private final RestTemplate restTemplate = new RestTemplate();

    private static CarService carServiceInstance = null;

    public static CarService getInstance() {
        if (carServiceInstance == null) {
            carServiceInstance = new CarService();
        }
        return carServiceInstance;
    }

    private CarService() {

    }


    public List<VozillaCar> getAllCars() {
        try {
            URI uriRequest = UriComponentsBuilder.fromHttpUrl(sourceRoot + "/cars")
                    .build().encode().toUri();
            return Arrays.asList(ofNullable(restTemplate.getForObject(uriRequest, VozillaCar[].class))
                    .orElse(new VozillaCar[0]));
        } catch(RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    public VozillaCar getNearestCarFromLocation(GPSLocation location) {
        RequestFactory requestFactory = new RequestFactory();
        RestTemplate restTemplate = requestFactory.getRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<VozillaCar> responseEntity = restTemplate.exchange(sourceRoot + "/cars/location", HttpMethod.GET,
                new HttpEntity<>(location, headers), VozillaCar.class);
        return responseEntity.getBody();
    }
}
