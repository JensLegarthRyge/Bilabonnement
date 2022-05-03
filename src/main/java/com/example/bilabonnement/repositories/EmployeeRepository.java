package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Employee;

import java.util.List;

public class EmployeeRepository implements CRUDInterface<Employee>{

    @Override
    public boolean create() {
        return false;
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public Employee getSingleById() {
        return null;
    }

    @Override
    public Employee delete() {
        return null;
    }
}
