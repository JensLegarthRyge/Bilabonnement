package com.example.bilabonnement.models;

//Jens Legarth Ryge

import com.example.bilabonnement.models.Enum.AccessFeatures;

import java.util.ArrayList;

public class Employee extends User {
    private String password;
    private ArrayList<AccessFeatures> accessFeatures;
    private boolean isAdmin;

    public Employee(int id, String firstName, String lastName, String password, AccessFeatures accessFeature, boolean isAdmin) {
        super(id, firstName, lastName);
        this.password = password;
        this.accessFeatures.add(accessFeature);
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "password='" + password + '\'' +
                ", accessFeatures=" + accessFeatures +
                ", isAdmin=" + isAdmin +
                "} " + super.toString();
    }
}
