package com.example.bilabonnement.models;


//Jens Legarth Ryge
public class PickupLocation {
    private int id;
    private String name;
    private String streetName;
    private String streetNumber;
    private int postcode;

    public PickupLocation(int id, String name, String streetName, String streetNumber, int postcode) {
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

    public String getStreetNumber() {
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

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getStreetNameNumberPostcode( ){
        return this.id + " - " + this.streetName + " " + this.streetNumber + ", " + this.postcode;
    }
}
