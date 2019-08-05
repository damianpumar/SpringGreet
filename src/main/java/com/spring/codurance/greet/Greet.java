package com.spring.codurance.greet;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Greet {
    private final String STRANGER = "Stranger";
    private final String SALUTATIONS_MESSAGE = "Hello %s, good %s!";
    private final String AFTERNOON = "afternoon";
    private final String MORNING = "morning";

    private final Clock clock;
    private final String name;

    public Greet(Clock clock, String name) {
        this.clock = clock;
        this.name = name;
    }

    @JsonProperty("salutation")
    public String salutation() {
        return String.format(SALUTATIONS_MESSAGE, getName(), getPartOfDay());
    }

    private String getPartOfDay() {
        return clock.isAfternoon() ? AFTERNOON : MORNING;
    }

    private String getName() {
        return isNameEmpty() ? STRANGER : name.trim();
    }

    private boolean isNameEmpty() {
        return name == null || name.trim().isEmpty();
    }
}
