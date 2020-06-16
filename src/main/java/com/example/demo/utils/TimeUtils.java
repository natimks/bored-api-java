package com.example.demo.utils;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class TimeUtils {

    public static int getMinutesOfNow() {
        Instant instant = Instant.now();
        ZonedDateTime zDateTime = instant.atZone(ZoneOffset.of("-03:00"));

        int hour = zDateTime.getHour();
        int minutes = zDateTime.getMinute();

        hour *= 60;

        return hour + minutes;
    }
}