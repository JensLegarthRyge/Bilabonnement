package com.example.bilabonnement.models;

import com.example.bilabonnement.repositories.PickupLocationRepository;

import java.util.ArrayList;

public class PickupLocation {
    private int id;
    private String name;
    private String streetName;
    private String streetNumber;
    private int postcode;

    @Override
    public String toString() {
        return "PickupLocation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", postcode=" + postcode +
                '}';
    }

    public PickupLocation(int id, String name, String streetName, String streetNumber, int postcode) {
        this.id = id;
        this.name = name;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postcode = postcode;
    }

    public static void main(String[] args) {
        PickupLocationRepository plr = new PickupLocationRepository();
        ArrayList<PickupLocation> ballade = plr.getAll();

        for (PickupLocation cpl: ballade) {
            System.out.println(cpl.getName());
        }

        System.out.println(plr.getSingleById(3));
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
