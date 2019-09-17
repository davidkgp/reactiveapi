package com.example.reactive.reactiveapi.config;

import com.example.reactive.reactiveapi.components.StudentHandlers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouteConfiguration {

    @Bean
    public RouterFunction<ServerResponse> routes(StudentHandlers studentHandlers) {
        return route(GET("/myapi/students"), studentHandlers.getStudents)
                .andRoute(GET("/myapi/student/{id}"), studentHandlers.getStudent)
                .andRoute(POST("/myapi/student")
                        .and(accept(MediaType.APPLICATION_JSON))
                        .and(contentType(MediaType.APPLICATION_JSON)), studentHandlers.createStudent)
                ;
    }

}
