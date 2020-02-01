package com.wroclawhelperf.service;

import com.wroclawhelperf.config.Config;
import com.wroclawhelperf.domain.User;
import com.wroclawhelperf.domain.UserToVerify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static java.util.Optional.ofNullable;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final RestTemplate restTemplate = new RestTemplate();
    private final String sourceRoot = Config.SOURCE_ROOT;

    private static UserService userServiceInstance = null;

    public static UserService getInstance() {
        if(userServiceInstance == null) {
            userServiceInstance = new UserService();
        }
        return userServiceInstance;
    }

    private UserService(){

    }

    public User getUserByUsername(String username) {
        URI sourceUri = UriComponentsBuilder.fromHttpUrl(sourceRoot + "/users/username/" + username)
                .build().encode().toUri();
        return restTemplate.getForObject(sourceUri, User.class);
    }

    public boolean verifyUser(UserToVerify user) {
        RequestFactory requestFactory = new RequestFactory();
        RestTemplate restTemplate = requestFactory.getRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<String> responseEntity = restTemplate.exchange(sourceRoot + "/users/verify", HttpMethod.GET,
                new HttpEntity<>(user, headers), String.class);
        return (ofNullable(responseEntity.getBody()).orElse("false")).equals("true");
    }

    public User updateUser(User user) {
        RequestFactory requestFactory = new RequestFactory();
        RestTemplate restTemplate = requestFactory.getRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<User> responseEntity = restTemplate.exchange(sourceRoot + "/users", HttpMethod.PUT,
                new HttpEntity<>(user, headers), User.class);
        return responseEntity.getBody();
    }


}
