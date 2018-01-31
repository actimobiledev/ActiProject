package com.actiknow.actiproject.model;

/**
 * Created by l on 29/01/2018.
 */

public class Product {
    int id;
    String product_number,spot,weight;

    public Product(int id, String product_number, String spot, String weight) {
        this.id = id;
        this.product_number = product_number;
        this.spot = spot;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_number() {
        return product_number;
    }

    public void setProduct_number(String product_number) {
        this.product_number = product_number;
    }

    public String getSpot() {
        return spot;
    }

    public void setSpot(String spot) {
        this.spot = spot;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
