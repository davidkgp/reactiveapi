package com.example.reactive.reactiveapi.components;

import com.example.reactive.reactiveapi.dto.Employee;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@AllArgsConstructor
public class EmployeeClient {


    private WebClient clientEmployee;

    public Flux<Employee> getEmployeeFlux() {
        return clientEmployee.get()
                .uri("/api/v1/employees")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(Employee.class);
    }


}
