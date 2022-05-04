package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;

import java.util.ArrayList;

//Jens Legarth Ryge

public class CarRepository implements CRUDInterface<Car> {
    @Override
    public boolean create(Car entity) {
        return false;
    }

    @Override
    public ArrayList<Car> getAll() {
        return null;
    }

    @Override
    public Car getSingleById(int id) {
        return null;
    }

    @Override
    public boolean update(Car entity) {
        return false;
    }

    @Override
    public Car delete() {
        return null;
    }
}
