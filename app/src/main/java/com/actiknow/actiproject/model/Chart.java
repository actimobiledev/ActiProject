package com.actiknow.actiproject.model;

/**
 * Created by l on 29/01/2018.
 */

public class Chart {
    int id;
    String chart_title, radius;

    public Chart(int id, String chart_title, String radius) {
        this.id = id;
        this.chart_title = chart_title;
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChart_title() {
        return chart_title;
    }

    public void setChart_title(String chart_title) {
        this.chart_title = chart_title;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }
}
