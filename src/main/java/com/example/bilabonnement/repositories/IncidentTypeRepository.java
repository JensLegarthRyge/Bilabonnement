package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Incident;
import com.example.bilabonnement.models.IncidentType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class IncidentTypeRepository {
    //Johannes Forsting
    Connection connection = DatabaseConnectionManager.getConnection();

    public IncidentType getSingleById(int id) {
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM incident_types WHERE incident_type_id = '"+id+"'");
            rs.next();

            int incidentTypeId = rs.getInt("incident_type_id");
            String type = rs.getString("type");
            int price = rs.getInt("price");


            return new IncidentType(incidentTypeId, type, price);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<IncidentType> getAll() {
        ArrayList<IncidentType> incidentTypes = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM incident_types AS i WHERE i.incident_type_id IS NOT NULL");

            while(rs.next()){
                int incidentId = rs.getInt("incident_type_id");
                String type = rs.getString("type");
                int price = rs.getInt("price");

                incidentTypes.add(new IncidentType(incidentId, type, price));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incidentTypes;
    }
}
