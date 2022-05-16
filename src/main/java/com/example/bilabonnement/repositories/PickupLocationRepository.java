package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.PickupLocation;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//Jens Legarth Ryge

public class PickupLocationRepository implements CRUDInterface<PickupLocation> {
    Connection connection = DatabaseConnectionManager.getConnection();

    @Override
    public boolean create(PickupLocation entity) {
        return false;
    }

    @Override
    public ArrayList<PickupLocation> getAll() {
        ArrayList<PickupLocation> pickupLocations = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM pickup_locations");

            while(rs.next()) {
                pickupLocations.add(
                        new PickupLocation(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("street_name"),
                                rs.getString("street_number"),
                                rs.getInt("postcode")
                        )
                );
            }
            return pickupLocations;
        } catch (SQLException e){
            System.out.println("An error occured when fetching all pickup locations");
            return null;
        }
    }

    @Override
    public PickupLocation getSingleById(int id) {
        try{
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM pickup_locations WHERE id = '"+id+"'");
            rs.next();

            return new PickupLocation(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("street_name"),
                    rs.getString("street_number"),
                    rs.getInt("postcode")
            );

        } catch (SQLException e){
            System.out.println("An error occurred fetching single pickup location by id");
            return null;
        }
    }

    @Override
    public boolean update(PickupLocation entity) {
        return false;
    }

    @Override
    public void delete(int id) {

    }
}
