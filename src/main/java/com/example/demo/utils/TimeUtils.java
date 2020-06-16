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

    public static String convertMinutesToString(int time) {
        int minutes = time % 60;
        int hours = (time - minutes) / 60;
        StringBuilder result = new StringBuilder();

        String hoursStr = String.format("%02d", hours);
        String minutesStr = String.format("%02d", minutes);
        result.append(hoursStr).append(":").append(minutesStr);

        return result.toString();
    }
}