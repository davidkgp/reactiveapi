package com.example.reactive.reactiveapi.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class Student {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final Address residence;

}

