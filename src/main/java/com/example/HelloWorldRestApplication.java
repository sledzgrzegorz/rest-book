package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestApplication {

    @RequestMapping("/greet")
    public String helloGreeting() {
        return "Hello REST";
    }
}