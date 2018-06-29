package com.trantor.delugeadapter.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.zip.GZIPInputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(value = "classpath:deluge.properties")
public class LoginControllerIntegrationTest {

    @Autowired
    private LoginController loginController;

    @Value("${web.address}")
    private String address;
    @Value("${web.port}")
    private Integer port;
    @Value("${web.password}")
    private String password;
    @Value("${web.json.api}")
    private String json;


    /**
     * Checks if login authentication is successful. It nedds a running Deluge WebUI on the port 8112 on the local computer.
     * @throws JsonProcessingException
     */
    @Test
    public void whenLoginWIthValidData_thenReturnTrueResponse() throws IOException {
        //given
        URI uri = URI.create(address + ":" + port + json);

        // when
        ResponseEntity<String> response = loginController.login(uri, password);

        // then
        assertThat("HTTP response was OK", response.getStatusCode(), equalTo(OK));
        assertThat("Authentication was successful", response.getBody(), containsString("\"result\": true"));
        assertThat("No errors", response.getBody(), containsString("\"error\": null"));
    }
}