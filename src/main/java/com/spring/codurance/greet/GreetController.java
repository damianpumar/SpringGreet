package com.spring.codurance.greet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @GetMapping("/greet")
    public Greet greet(String name) {
        return new Greet(name);
    }
}
