package com.example.bilabonnement.models;

//Jens Legarth Ryge

import com.example.bilabonnement.models.Enum.AccessFeatures;

import java.util.ArrayList;

public class Employee extends User {
    private String password;
    private ArrayList<AccessFeatures> accessFeatures = new ArrayList<>();
    private boolean isAdmin;

    public Employee(int id, String firstName, String lastName, String password, AccessFeatures accessFeature, boolean isAdmin) {
        super(id, firstName, lastName);
        this.password = password;
        this.accessFeatures.add(accessFeature);
        this.isAdmin = isAdmin;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<AccessFeatures> getAccessFeatures() {
        return accessFeatures;
    }

    public boolean isAdmin() {
        return isAdmin;
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
