package com.scolerad.spring.client.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.scolerad.spring.client")
public class MyConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
