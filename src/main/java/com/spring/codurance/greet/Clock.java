package com.spring.codurance.greet;

import java.time.LocalTime;
import java.util.Objects;

public class Clock {
    private final int hour;

    public Clock() {
        this(LocalTime.now().getHour());
    }

    Clock(int hour) {
        this.hour = hour;
    }

    public boolean isAfternoon() {
        return hour >= 12;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clock clock = (Clock) o;
        return hour == clock.hour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour);
    }
}
