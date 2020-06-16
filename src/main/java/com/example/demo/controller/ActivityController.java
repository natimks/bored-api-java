package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Activities;
import com.example.demo.model.Activity;
import com.example.demo.utils.ParamsUtils;
import com.example.demo.utils.TimeUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ActivityController {
    private static final int[] MINUTES = { 300, 480, 720, 840, 1080, 1439 };

    @GetMapping("/activity")
    public Activity getActivity(RestTemplate restTemplate) {
        String baseUrl = "http://www.boredapi.com/api/activity?";
        int minutes = TimeUtils.getMinutesOfNow();
        List<String> paramsType = ParamsUtils.defineParamsActivityType(minutes);
        String url = formatURL(baseUrl, paramsType);
        Activity activity = restTemplate.getForObject(url, Activity.class);
        activity.setHour(TimeUtils.convertMinutesToString(minutes));
        return activity;
    }

    @GetMapping("/activities")
    public Activities getDailyActivities(RestTemplate restTemplate) {
        String baseUrl = "http://www.boredapi.com/api/activity?participants=2";
        Activities activities = new Activities();
        for (int minute : MINUTES) {
            List<String> paramsType = ParamsUtils.defineParamsActivityType(minute);
            String url = formatURL(baseUrl, paramsType);

            Activity activity = restTemplate.getForObject(url, Activity.class);
            activity.setHour(TimeUtils.convertMinutesToString(minute));
            activities.addActivity(activity);
        }
        return activities;
    }

    private String formatURL(String url, List<String> paramsTypeList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(url);
        for (String type : paramsTypeList) {
            stringBuilder.append("&type=").append(type);
        }
        return stringBuilder.toString();
    }
}