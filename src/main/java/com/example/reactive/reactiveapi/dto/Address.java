package com.example.reactive.reactiveapi.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class Address {
    private final String postCode;
    private final String houseNumber;
    private final String city;

}
