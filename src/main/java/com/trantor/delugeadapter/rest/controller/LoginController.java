package com.trantor.delugeadapter.rest.controller;

import com.trantor.delugeadapter.rest.dto.AuthenticationResponse;
import com.trantor.delugeadapter.rest.dto.DelugeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;
import java.util.Random;

import static org.springframework.http.HttpMethod.POST;

@Controller
public class LoginController {
    private Random random = new Random();

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.method.login}")
    private String methodLogin;

    public ResponseEntity<AuthenticationResponse> login(URI uri, String password) {
        HttpEntity<DelugeRequest> request = new HttpEntity<>(new DelugeRequest(random.nextInt(1000), methodLogin, Collections.singletonList(password)));
        return restTemplate.exchange(uri, POST, request, AuthenticationResponse.class);
    }
}
