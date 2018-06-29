package com.trantor.delugeadapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
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
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }
}
