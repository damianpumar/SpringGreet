package com.spring.codurance.greet;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GreetControllerShould {

    private GreetController controller;

    @Before
    public void setUp() {
        controller = new GreetController();
    }

    @Test
    public void greet_with_name() {
        Greet greet = controller.greet("Damián");

        assertThat(greet.salutation()).isEqualTo("Hello Damián, good morning!");
    }

    @Test
    public void greet_stranger() {
        Greet greet = controller.greet(null);

        assertThat(greet.salutation()).isEqualTo("Hello Stranger, good morning!");
    }

    @Test
    public void greet_stranger_when_name_is_blank() {
        Greet greet = controller.greet("");

        assertThat(greet.salutation()).isEqualTo("Hello Stranger, good morning!");
    }

    @Test
    public void greet_stranger_when_name_only_has_spaces() {
        Greet greet = controller.greet("    ");

        assertThat(greet.salutation()).isEqualTo("Hello Stranger, good morning!");
    }
    
    @Test 
    public void greet_name_with_spaces() {
        Greet greet = controller.greet("   Damián   ");

        assertThat(greet.salutation()).isEqualTo("Hello Damián, good morning!");
    }
}