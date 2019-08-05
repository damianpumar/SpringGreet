package com.spring.codurance.greet;

import org.springframework.stereotype.Service;

@Service
public class TimeService {

    public Clock getTime() {
        return new Clock();
    }
}
