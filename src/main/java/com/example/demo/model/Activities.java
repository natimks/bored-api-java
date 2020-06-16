package com.example.demo.model;

import java.util.ArrayList;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Activities {
    private ArrayList<Activity> activities = new ArrayList<>();

    public void addActivity(Activity activity) {
        if (Objects.isNull(activity) || Objects.isNull(activity.getActivity())) {
            return;
        }
        activities.add(activity);
    }
}