package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.City;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;

import java.sql.*;
import java.util.ArrayList;

//Jens Legarth Ryge

public class CityRepository implements CRUDInterface<City> {
    Connection connection = DatabaseConnectionManager.getConnection();

    @Override
    //Not relevant
    public boolean create(City entity) {
        return false;
    }

    @Override
    public ArrayList<City> getAll() {
        ArrayList<City> allCities = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM cities");
            while (rs.next()) {
                int postcode = rs.getInt("postcode");
                String cityName = rs.getString("city");
                allCities.add(new City(postcode, cityName));
            }
        } catch (SQLException e) {
            System.out.println("An error occured while getting all cities");
            return null;
        }
        return null;
    }

    @Override
    public City getSingleById(int id) {
        try{
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM cities WHERE postcode = '"+id+"'");
            rs.next();
            int postcode = rs.getInt("postcode");
            String cityName = rs.getString("city");
            return new City(postcode,cityName);
        } catch (SQLException e){
            System.out.println("An error occured when fetching city by id");
            return null;
        }
    }

    @Override
    //Not relevant
    public boolean update(City entity) {
        return false;
    }

    @Override
    //Not relevant
    public void delete(int id) {
    }
}
