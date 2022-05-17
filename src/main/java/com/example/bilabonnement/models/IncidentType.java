package com.example.bilabonnement.models;

public class IncidentType {
    private int id;
    private String type;
    private int price;

    public IncidentType(int id, String type, int price){
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}
