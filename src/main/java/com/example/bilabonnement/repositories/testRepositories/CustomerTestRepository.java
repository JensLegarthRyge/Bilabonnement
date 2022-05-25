package com.example.bilabonnement.repositories.testRepositories;

import com.example.bilabonnement.models.Customer;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;

import java.util.ArrayList;
import java.util.Arrays;
//Jens Legarth Ryge
public class CustomerTestRepository implements CRUDInterface<Customer> {
    ArrayList<Customer> allCustomers = new ArrayList<>(
            Arrays.asList(
                    new Customer(1,"Jens", "Legarth Ryge", "Vølundsgade 4, 1. TH", 2200,
                            "jens.l.ryge@pol.dk", "28683398", 1005981005, 5012,2117029008),
                    new Customer(2,"Johannes", "Forsting", "Hundevej 1", 3390,
                            "johannes.forsting@gmail.com", "28683398", 1234556677, 1112,712783948),
                    new Customer(3,"Mads", "Legarth Ryge", "kovej 12", 4600,
                            "jens.l.ryge@pol.dk", "28683398", 1325981005, 2020,2117789128)
            )
    );

    @Override
    public boolean create(Customer entity) {
        return false;
    }

    @Override
    public ArrayList<Customer> getAll() {
        return allCustomers;
    }

    @Override
    public Customer getSingleById(int id) {
        for (Customer cc: allCustomers) {
            if (cc.getId()==id){
                return cc;
            }
        }
        return null;
    }

    @Override
    public boolean update(Customer entity) {
        return false;
    }

    @Override
    public void delete(int id) {

    }
}
