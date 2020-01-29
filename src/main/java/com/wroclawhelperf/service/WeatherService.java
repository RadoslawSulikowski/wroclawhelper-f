package com.wroclawhelperf.service;

import com.wroclawhelperf.config.Config;
import com.wroclawhelperf.domain.GPSLocation;
import com.wroclawhelperf.domain.Weather;
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
public class WeatherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherService.class);

    private String sourceRoot = Config.SOURCE_ROOT;
    private RestTemplate restTemplate = new RestTemplate();

    private static WeatherService weatherServiceInstance = null;

    public static WeatherService getInstance() {
        if (weatherServiceInstance == null) {
            weatherServiceInstance = new WeatherService();
        }
        return weatherServiceInstance;
    }

    private WeatherService() {

    }


    public List<Weather> getWeatherOnAllStations() {
        URI uriRequest = UriComponentsBuilder.fromHttpUrl(sourceRoot + "/weather")
                .build().encode().toUri();
        try {
            return Arrays.asList(ofNullable(restTemplate.getForObject(uriRequest, Weather[].class)).orElse(new Weather[0]));
        } catch(RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    public Weather getWeatherOnStation(String stationShortName) {
        URI uriRequest = UriComponentsBuilder.fromHttpUrl(sourceRoot + "/weather/" + stationShortName)
                .build().encode().toUri();
        try {
            return restTemplate.getForObject(uriRequest, Weather.class);
        } catch(RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

    public Weather getWeatherNearestLocation(GPSLocation location) {
        RequestFactory requestFactory = new RequestFactory();
        RestTemplate restTemplate = requestFactory.getRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<Weather> responseEntity = restTemplate.exchange(sourceRoot + "/weather/location", HttpMethod.GET,
                new HttpEntity<>(location, headers), Weather.class);
        return responseEntity.getBody();
    }
}
