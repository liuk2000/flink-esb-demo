package com.example.demo.components;

import org.springframework.stereotype.Component;

@Component
public class TestComponent {

    public String sayHello(String name) {
        return "Hello " + name;
    }

}
