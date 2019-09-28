package com.example.reactive.reactiveapi.components;

import com.example.reactive.reactiveapi.dto.Address;
import com.example.reactive.reactiveapi.dto.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Component
public class StudentHandlers {

    //this api would currently give parse error in browser,if triggered from browser
    public HandlerFunction<ServerResponse> getLotsOfStudents = serverRequest -> ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_STREAM_JSON)
            .body(Flux.just(
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                    new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen"))

            ), Student.class);

    public HandlerFunction<ServerResponse> getStudents = serverRequest -> ServerResponse
            .ok()
            .body(
                    Flux.just(
                            Arrays.asList(new Student("Tom", "Hardy", 67, new Address("1156RT", "87A", "Amstelveen")),
                                    new Student("Arnold", "Dan", 63, new Address("1157RT", "817A", "Amstelveen")))
                    ), List.class);

    public HandlerFunction<ServerResponse> getStudent = serverRequest -> ServerResponse
            .ok()
            .header("type", "custom")
            .contentType(MediaType.APPLICATION_JSON)
            .body(
                    Mono.just(new Student("Arnold", "Dan", 63, new Address("1157RT", "817A", "Amstelveen"))
                    ), Student.class);

    public HandlerFunction<ServerResponse> createStudent = serverRequest -> ServerResponse
            .status(HttpStatus.CREATED)
            .header("type", "custom")
            .contentType(MediaType.APPLICATION_JSON).build();
}
