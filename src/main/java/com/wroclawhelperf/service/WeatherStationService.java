package com.wroclawhelperf.service;

import com.wroclawhelperf.config.Config;
import com.wroclawhelperf.domain.WeatherStation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class WeatherStationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherStationService.class);

    private RestTemplate restTemplate = new RestTemplate();
    private String sourceURL = Config.SOURCE_ROOT;

    private static WeatherStationService weatherServiceInstance = null;

    public static WeatherStationService getInstance() {
        if (weatherServiceInstance == null) {
            weatherServiceInstance = new WeatherStationService();
        }
        return weatherServiceInstance;
    }

    private WeatherStationService() {

    }


    public List<WeatherStation> getWeatherStations() {
        URI uriRequest = UriComponentsBuilder.fromHttpUrl(sourceURL + "/weatherstations")
                .build().encode().toUri();
        try {
            return Arrays.asList(ofNullable(restTemplate.getForObject(uriRequest, WeatherStation[].class))
                    .orElse(new WeatherStation[0]));
        } catch(RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }
}
