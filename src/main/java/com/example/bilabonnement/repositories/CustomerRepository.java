package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Customer;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Jens Legarth Ryge

public class CustomerRepository implements CRUDInterface<Customer> {

    @Override
    public boolean create(Customer entity) {

        return false;
    }


    @Override
    public ArrayList<Customer> getAll() {
        return null;
    }

    @Override
    public Customer getSingleById(int id) {
        return null;
    }

    @Override
    public boolean update(Customer entity) {
        return false;
    }

    @Override
    public Customer delete() {
        return null;
    }
}
