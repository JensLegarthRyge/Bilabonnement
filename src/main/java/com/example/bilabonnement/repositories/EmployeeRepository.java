package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Employee;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;

import java.util.ArrayList;

//Jens Legarth Ryge

public class EmployeeRepository implements CRUDInterface<Employee> {
    @Override
    public boolean create(Employee entity) {
        return false;
    }

    @Override
    public ArrayList<Employee> getAll() {
        return null;
    }

    @Override
    public Employee getSingleById(int id) {
        return null;
    }

    @Override
    public boolean update(Employee entity) {
        return false;
    }

    @Override
    public Employee delete() {
        return null;
    }
}
