package com.actiknow.actiproject.model;

/**
 * Created by l on 29/01/2018.
 */

public class Chart {
    int id;
    String chart_title, radius,percentage;

    public Chart(int id, String chart_title, String radius,String percentage) {
        this.id = id;
        this.chart_title = chart_title;
        this.radius = radius;
        this.percentage = percentage;
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

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
