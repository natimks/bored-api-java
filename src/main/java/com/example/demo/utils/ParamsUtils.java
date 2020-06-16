package com.example.demo.utils;

import java.util.Arrays;
import java.util.List;

public class ParamsUtils {
    public static List<String> defineParamsActivityType(int minutes) {
        // de 00:00 as 5:00 hrs
        if (minutes >= 0 && minutes <= 300) {
            return Arrays.asList("relaxation", "music", "recreational");
            // de 5:00 as 8:00
        } else if (minutes > 300 && minutes <= 480) {
            return Arrays.asList("education");
            // de 8:00 ao 12:00
        } else if (minutes > 480 && minutes <= 720) {
            return Arrays.asList("busywork");
            // de 12:00 ao 14:00
        } else if (minutes > 720 && minutes <= 840) {
            return Arrays.asList("social", "education", "relaxation", "recreational");
            // de 14:00 ao 18:00
        } else if (minutes > 840 && minutes <= 1080) {
            return Arrays.asList("busywork");
            // de 18:00 ao 23:59
        } else if (minutes > 1080 && minutes <= 1439) {
            return Arrays.asList("social", "education", "relaxation", "recreational", "music");
        }
        return Arrays.asList();
    }
}