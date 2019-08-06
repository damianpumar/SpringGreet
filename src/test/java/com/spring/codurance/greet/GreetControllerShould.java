package com.spring.codurance.greet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class GreetControllerShould {

    private GreetController controller;

    @Mock
    private TimeService timeService;

    @Before
    public void setUp() {
        given(timeService.getTime()).willReturn(new Clock(10));

        controller = new GreetController(timeService);
    }

    @Test
    public void greet_with_name() {
        Greet greet = controller.greet("Damián");

        assertThat(greet.salutation()).startsWith("Hello Damián");
    }

    @Test
    public void greet_stranger() {
        Greet greet = controller.greet(null);

        assertThat(greet.salutation()).isEqualTo("Hello Strangers, good morning!");
    }

    @Test
    public void greet_stranger_when_name_is_blank() {
        Greet greet = controller.greet("");

        assertThat(greet.salutation()).isEqualTo("Hello Strangers, good morning!");
    }

    @Test
    public void greet_stranger_when_name_only_has_spaces() {
        Greet greet = controller.greet("    ");

        assertThat(greet.salutation()).isEqualTo("Hello Strangers, good morning!");
    }
    
    @Test 
    public void greet_name_with_spaces() {
        Greet greet = controller.greet("   Damián   ");

        assertThat(greet.salutation()).isEqualTo("Hello Damián, good morning!");
    }

    @Test 
    public void greet_afternoon_after_12() {
        given(timeService.getTime()).willReturn(new Clock(13));

        Greet greet = controller.greet("DefaultName");

        assertThat(greet.salutation()).endsWith("good afternoon!");
    }
    
    @Test 
    public void greet_afternoon_equal_12() {
        given(timeService.getTime()).willReturn(new Clock(12));

        Greet greet = controller.greet("DefaultName");

        assertThat(greet.salutation()).endsWith("good afternoon!");
    }

    @Test
    public void greet_morning_before_12() {
        given(timeService.getTime()).willReturn(new Clock(11));

        Greet greet = controller.greet("DefaultName");

        assertThat(greet.salutation()).endsWith("good morning!");
    }
}