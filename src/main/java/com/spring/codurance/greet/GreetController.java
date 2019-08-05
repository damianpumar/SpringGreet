package com.spring.codurance.greet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    private final TimeService timeService;

    public GreetController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/greet")
    public Greet greet(String name) {
        return new Greet(timeService.getTime(), name);
    }
}
