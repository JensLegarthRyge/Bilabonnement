package com.example.bilabonnement.models;

//Jens Legarth Ryge

import com.example.bilabonnement.models.Enum.AccessFeatures;

import java.util.List;

public class Employee extends User {
    private String password;
    private List<AccessFeatures> accessFeatures;
    private boolean isAdmin;

    public Employee(int id, String firstName, String lastName, String password, List<AccessFeatures> accessFeatures, boolean isAdmin) {
        super(id, firstName, lastName);
        this.password = password;
        this.accessFeatures = accessFeatures;
        this.isAdmin = isAdmin;
    }
}
