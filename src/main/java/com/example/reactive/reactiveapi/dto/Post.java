package com.example.reactive.reactiveapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Post {

   private int userId;
    private int id;
    private String title;
    private String body;
}
