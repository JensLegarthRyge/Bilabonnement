package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Employee;
import com.example.bilabonnement.models.Incident;
import com.example.bilabonnement.models.IncidentReport;
import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

//Johannes Forsting

public class IncidentReportRepository implements CRUDInterface<IncidentReport> {
    Connection connection = DatabaseConnectionManager.getConnection();
    @Override
    public boolean create(IncidentReport entity) {
        int leaseReportId = entity.getLeaseReportId();
        int price = 0;
        int customerPrice = 0;

        String query = "INSERT INTO `bilabonnement`.`incident_report` (`lease_report_id`, `total_price`, `customer_price`) " +
                "VALUES ('"+leaseReportId+"', '"+price+"', '"+customerPrice+"');";
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
    public ArrayList<IncidentReport> getAll() {
        ArrayList<IncidentReport> incidentReports = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM incident_report AS i WHERE i.incident_report_id IS NOT NULL");

            while(rs.next()){
                int incidentReportId = rs.getInt("incident_report_id");
                int leaseReportId = rs.getInt("lease_report_id");
                int totalPrice = rs.getInt("total_price");
                int customerPrice = rs.getInt("customer_price");

                incidentReports.add(new IncidentReport(incidentReportId, leaseReportId, totalPrice, customerPrice));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incidentReports;
    }

    @Override
    public IncidentReport getSingleById(int id) {
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM incident_report WHERE incident_report_id = '"+id+"'");
            rs.next();

            int incidentReportId = rs.getInt("incident_report_id");
            int leaseReportId = rs.getInt("lease_report_id");
            int totalPrice = rs.getInt("total_price");
            int customerPrice = rs.getInt("customer_price");

            return new IncidentReport(incidentReportId, leaseReportId, totalPrice, customerPrice);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(IncidentReport entity) {
        int incidentReportId = entity.getId();
        int leaseReportId = entity.getLeaseReportId();
        int price = 0;
        int customerPrice = 0;

        String query = "SELECT * FROM incident_report AS i WHERE i.incident_report_id = '" + incidentReportId + "'";

        String query2 = "UPDATE incident_report SET " +
                "lease_report_id='" + leaseReportId + "' , " +
                "total_price='" + price + "' , " +
                "customer_price='" + customerPrice + "'" +
                "WHERE incident_report_id='" + incidentReportId + "'";
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
        String query = "DELETE FROM incident_report WHERE incident_report_id='"+id+"';";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public IncidentReport getSpecificByLeaseReportId(int id){
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM incident_report AS i WHERE i.lease_report_id = '"+id+"';");

            rs.next();

            int incidentReportId = rs.getInt("incident_report_id");
            int leaseReportId = rs.getInt("lease_report_id");
            int totalPrice = rs.getInt("total_price");
            int customerPrice = rs.getInt("customer_price");

            return new IncidentReport(incidentReportId, leaseReportId, totalPrice, customerPrice);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
