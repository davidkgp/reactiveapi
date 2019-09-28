package com.example.reactive.reactiveapi.components;

import com.example.reactive.reactiveapi.dto.Post;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class PostClient {


    private WebClient client;

    public Flux<Post> getPostFlux() {
        return client.get()
                .uri("/posts")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(Post.class);
    }

    //this should give a com.fasterxml.jackson.databind.exc.MismatchedInputException:
    public Mono<Post> getPostMono() {
        return client.get()
                .uri("/posts")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(Post.class);
    }


}
