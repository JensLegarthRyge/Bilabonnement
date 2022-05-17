package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Incident;
import com.example.bilabonnement.models.IncidentType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IncidentTypeRepository {
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
}
