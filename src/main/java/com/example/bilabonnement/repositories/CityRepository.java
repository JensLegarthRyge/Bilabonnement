package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.City;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;

import java.util.ArrayList;

//Jens Legarth Ryge

public class CityRepository implements CRUDInterface<City> {
    @Override
    public boolean create(City entity) {
        return false;
    }

    @Override
    public ArrayList<City> getAll() {
        return null;
    }

    @Override
    public City getSingleById(int id) {
        return null;
    }

    @Override
    public boolean update(City entity) {
        return false;
    }

    @Override
    public City delete() {
        return null;
    }
}
