package com.example.reactive.reactiveapi.components;

public class MyException extends RuntimeException{

    public MyException() {
    }

    public MyException(String s) {
        super(s);
    }

    public MyException(Throwable throwable) {
        super(throwable);
    }
}
