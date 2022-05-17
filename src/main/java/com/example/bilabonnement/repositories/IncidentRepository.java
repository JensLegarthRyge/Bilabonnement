package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Incident;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;

import java.sql.*;
import java.util.ArrayList;

//Johannes Forsting
public class IncidentRepository implements CRUDInterface<Incident> {
    Connection connection = DatabaseConnectionManager.getConnection();
    @Override
    public boolean create(Incident entity) {
        int incidentReportId = entity.getIncidentReportId();
        int incidentTypeId = entity.getIncidentTypeId();


        String query = "INSERT INTO `bilabonnement`.`incidents` (`incident_report_id`, `incident_type_id`) " +
                "VALUES ('"+incidentReportId+"', '"+incidentTypeId+"');";
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

    @Override
    public ArrayList<Incident> getAll() {
        ArrayList<Incident> incidents = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM incidents AS i WHERE i.incident_id IS NOT NULL");

            while(rs.next()){
                int incidentId = rs.getInt("incident_id");
                int incidentReportId = rs.getInt("incident_report_id");
                int incidentTypeId = rs.getInt("incident_type_id");

                incidents.add(new Incident(incidentId, incidentReportId, incidentTypeId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incidents;
    }

    @Override
    public Incident getSingleById(int id) {
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM incidents WHERE incident_id = '"+id+"'");
            rs.next();

            int incidentId = rs.getInt("incident_id");
            int incidentReportId = rs.getInt("incident_report_id");
            int incidenTypeId = rs.getInt("incident_type_id");


            return new Incident(incidentId, incidentReportId, incidenTypeId);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Incident entity) {
        int incidentId = entity.getId();
        int incidentReportId = entity.getIncidentReportId();
        int incidentTypeId = entity.getIncidentTypeId();

        String query = "SELECT * FROM incidents AS i WHERE i.incident_id = '" + incidentId + "'";

        String query2 = "UPDATE incident_report SET " +
                "incident_report_id='" + incidentReportId + "' , " +
                "incident_type_id='" + incidentTypeId + "'" +
                "WHERE incident_id='" + incidentId + "'";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.executeUpdate(query2);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM incidents WHERE incident_id='"+id+"';";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Incident> getALlSpecific(int id){
        ArrayList<Incident> incidents = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM incidents AS i WHERE i.incident_report_id = '"+id+"'");

            while(rs.next()){
                int incidentId = rs.getInt("incident_id");
                int incidentReportId = rs.getInt("incident_report_id");
                int incidentTypeId = rs.getInt("incident_type_id");

                incidents.add(new Incident(incidentId, incidentReportId, incidentTypeId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incidents;
    }
}
