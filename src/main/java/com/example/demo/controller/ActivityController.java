package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import com.example.demo.model.Activity;
import com.example.demo.utils.TimeUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ActivityController {
    private static final String URL = "http://www.boredapi.com/api/activity?";

    @GetMapping("/activity")
    public Activity getActivity(RestTemplate restTemplate) {
        int minutes = TimeUtils.getMinutesOfNow();
        List<String> paramsType = defineParamsActivityType(minutes);
        String url = formatURL(paramsType);
        Activity activity = restTemplate.getForObject(url, Activity.class);
        return activity;
    }

    private String formatURL(List<String> paramsTypeList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(URL);
        for (String type : paramsTypeList) {
            stringBuilder.append("&type=").append(type);
        }
        return stringBuilder.toString();
    }

    private List<String> defineParamsActivityType(int minutes) {
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
        } else if (minutes > 1080 && minutes <= 1493) {
            return Arrays.asList("social", "education", "relaxation", "recreational", "music");
        }
        return Arrays.asList();
    }
}