package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Activity {
    private String activity;
    private String accessibility;
    private String type;
    private String link;
    private String key;
    private String hour;
    private double price;
    private int participants;

}