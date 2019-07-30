package com.spring.codurance.greet;

public class Greet {
    private final String name;

    public Greet(String name) {
        this.name = name;
    }

    public String salutation() {
        return "Hello " + getName() + ", good morning!";
    }

    private String getName() {
        return isNameEmpty() ? "Stranger" : name.trim();
    }

    private boolean isNameEmpty() {
        return name == null || name.trim().isEmpty();
    }
}
