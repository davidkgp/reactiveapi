package com.example.reactive.reactiveapi.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.ExchangeFunctions;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.http.MediaType.TEXT_HTML;

@Configuration
public class SimpleConfig {

    @Value("${externalPostsUrl}")
    private String externalPostsUrl;

    @Value("${externalEmployeeUrl}")
    private String externalEmployeeUrl;

    @Bean("clientPost")
    public WebClient getWebClientPost() {

        return WebClient.create(externalPostsUrl);
    }

    @Bean("clientEmployee")
    public WebClient getWebClientEmployee() {

        return WebClient.builder()
                .baseUrl(externalEmployeeUrl)
                .exchangeStrategies(ExchangeStrategies.builder().codecs(this::acceptedCodecs).build())
                //By default, WebClient uses Reactor Netty as the HTTP client library. But others can be plugged in through a custom ClientHttpConnector.
                //.exchangeFunction(ExchangeFunctions.create())
                .build();
    }

    private void acceptedCodecs(ClientCodecConfigurer clientCodecConfigurer) {
        clientCodecConfigurer.customCodecs().encoder(new Jackson2JsonEncoder(new ObjectMapper(), TEXT_HTML));
        clientCodecConfigurer.customCodecs().decoder(new Jackson2JsonDecoder(new ObjectMapper(), TEXT_HTML));
    }


}
