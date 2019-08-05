package com.spring.codurance.greet;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClockServiceShould {

    @Test
    public void get_the_current_time() {
        TimeService timeService = new TimeService();

        assertThat(timeService.getTime()).isEqualTo(new Clock());
    }
}