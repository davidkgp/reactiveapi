package com.example.reactive.reactiveapi.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class SimpleConfig {

    @Value("${externalPostsUrl}")
    private String url;

    @Bean
    public WebClient getWebClientEmployee() {

        return WebClient.create(url);
    }


}
