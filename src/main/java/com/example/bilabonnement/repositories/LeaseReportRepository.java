package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

//Jens Legarth Ryge

public class LeaseReportRepository implements CRUDInterface<LeaseReport> {
    Connection connection = DatabaseConnectionManager.getConnection();
    @Override
    public boolean create(LeaseReport entity) {
        /*
        String registrationNumber = ;
        String lastName = entity.getLastName();
        String password = entity.getPassword();
        int isAdmin = 1;
        if(!entity.isAdmin()){
            isAdmin = 0;
        }
        int accessFeatures = entity.getAccessFeatures();
        String email = entity.getEmail();

        String query = "INSERT INTO `bilabonnement`.`employees` (`first_name`, `last_name`, `password`, `is_admin`, `access_features`, `email`) " +
                "VALUES ('"+firstName+"', '"+lastName+"', '"+password+"', '"+isAdmin+"', '"+accessFeatures+"', '"+email+"');";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.executeUpdate();
            return true;
        }
        catch (
                SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    String registrationNumber = ;
    String lastName = entity.getLastName();
    String password = entity.getPassword();
    int isAdmin = 1;
        if(!entity.isAdmin()){
        isAdmin = 0;
    }
    int accessFeatures = entity.getAccessFeatures();
    String email = entity.getEmail();

    String query = "INSERT INTO `bilabonnement`.`employees` (`first_name`, `last_name`, `password`, `is_admin`, `access_features`, `email`) " +
            "VALUES ('"+firstName+"', '"+lastName+"', '"+password+"', '"+isAdmin+"', '"+accessFeatures+"', '"+email+"');";
        try {
        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.executeUpdate();
        return true;
    }
        catch (
    SQLException e){
        e.printStackTrace();

         */
        return false;
    }

    @Override
    public ArrayList<LeaseReport> getAll() {
        return null;
    }

    @Override
    public LeaseReport getSingleById(int id) {
        return null;
    }

    @Override
    public boolean update(LeaseReport entity) {
        return false;
    }

    @Override
    public void delete(int id) {

    }
}
