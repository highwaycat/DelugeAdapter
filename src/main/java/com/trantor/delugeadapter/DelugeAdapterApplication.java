package com.trantor.delugeadapter;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@PropertySource(value = "classpath:deluge.properties")
public class DelugeAdapterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DelugeAdapterApplication.class, args);
    }

    /**
     * RestTemplate with apache http client extension for gzip compressed responses
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(HttpClientBuilder.create().build());
        return new RestTemplate(factory);
    }
}
