package com.trantor.delugeadapter.rest.controller;

import com.trantor.delugeadapter.rest.dto.AuthenticationResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(value = "classpath:deluge.properties")
public class LoginControllerTest {

    @Autowired
    private LoginController loginController;

    @Value("${web.address}")
    private String address;

    @Value("${web.port}")
    private Integer port;

    @Value("${web.password}")
    private String password;


    @Test
    public void whenLoginWIthValidData_thenReturnTrueResponse() {
        //given
        URI uri = URI.create(address + ":" + port);

        // when
        ResponseEntity<AuthenticationResponse> response = loginController.login(uri, password);

        // then
        assertThat("HTTP response was OK", response.getStatusCode(), equalTo(OK));
        assertThat("Authentication was successfull", response.getBody().getResult(), equalTo(true));

    }
}