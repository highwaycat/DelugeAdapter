package com.trantor.delugeadapter.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trantor.delugeadapter.rest.dto.AuthenticationResponse;
import com.trantor.delugeadapter.rest.dto.DelugeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;
import java.util.Random;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Controller
public class LoginController {
    private Random random = new Random();
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.method.login}")
    private String methodLogin;


    /**
     * Authentication via WebUI
     * @param uri Deluge WebUI JSON API uri
     * @param password
     * @return Complete response with authentication token in _session_id cookie
     * @throws JsonProcessingException
     */
    public ResponseEntity<String> login(URI uri, String password) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        DelugeRequest delugeRequest = new DelugeRequest(random.nextInt(1000), methodLogin, Collections.singletonList(password));
        HttpEntity<String> request = new HttpEntity<>(mapper.writeValueAsString(delugeRequest), headers);
        return restTemplate.exchange(uri, POST, request, String.class);
    }
}
