package com.example.bilabonnement.models;

public class pickupLocation {
    private int id;
    private String name;
    private String streetName;
    private int streetNumber;
    private int postcode;

    public pickupLocation(int id, String name, String streetName, int streetNumber, int postcode) {
        this.id = id;
        this.name = name;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postcode = postcode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
}
