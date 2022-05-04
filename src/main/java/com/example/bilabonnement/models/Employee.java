package com.example.bilabonnement.models;

//Jens Legarth Ryge

import com.example.bilabonnement.models.Enum.AccessFeatures;

import java.util.ArrayList;

public class Employee extends User {
    private String password;
    private int accessFeatures;
    private boolean isAdmin;

    public Employee(int id, String firstName, String lastName, String password, int accessFeature, boolean isAdmin, String email) {
        super(id, firstName, lastName, email);
        this.password = password;
        this.accessFeatures = accessFeature;
        this.isAdmin = isAdmin;
    }

    public Employee(String firstName, String lastName, String password, int accessFeatures, boolean isAdmin, String email) {
        super(firstName, lastName, email);
        this.password = password;
        this.accessFeatures = accessFeatures;
        this.isAdmin = isAdmin;
    }

    public String getPassword() {
        return password;
    }

    public int getAccessFeatures() {
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
