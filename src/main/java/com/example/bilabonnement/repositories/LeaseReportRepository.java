package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.Employee;
import com.example.bilabonnement.models.IncidentReport;
import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

//Johannes Forsting

public class LeaseReportRepository implements CRUDInterface<LeaseReport> {
    Connection connection = DatabaseConnectionManager.getConnection();

    @Override
    public boolean create(LeaseReport entity) {

        int carId = entity.getCarId();
        int employeeId = entity.getEmployeeId();
        int customerId = entity.getCustomerId();
        LocalDate createdDate = entity.getCreatedDate();
        int period = entity.getPeriod();
        int hasDeliveryInsurance = entity.hasReturnInsurance() ? 1 : 0;
        int hasLowDeductableInsurance = entity.hasLowDeductableInsurance() ? 1 : 0;
        int pickupAdressId = entity.getPickupLocationId();
        int isLimited = entity.isLimited() ? 1 : 0;
        double price = entity.getPrice();
        LocalDate startDate = entity.getStartDate();

        String query = "INSERT INTO `bilabonnement`.`leasing_report` (`car_Id`, `employee_id`, `customer_id`, `created_date`, `period`, `has_delivery_insurance`, `has_low_deductable_insurance`, `pickup_location_id`, `is_limited`, `price`, `start_date`) " +
                "VALUES ('"+carId+"', '"+employeeId+"', '"+customerId+"', '"+createdDate+"', '"+period+"', '"+hasDeliveryInsurance+"', '"+hasLowDeductableInsurance+"', '"+pickupAdressId+"', '"+isLimited+"', '"+price+"', '"+startDate+"');";
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
    public ArrayList<LeaseReport> getAll() {
        ArrayList<LeaseReport> leaseReports = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM leasing_report AS l WHERE l.lease_report_id IS NOT NULL");

            while(rs.next()){
                int id = rs.getInt("lease_report_id");
                int carId = rs.getInt("car_id");
                int employeeId = rs.getInt("employee_id");
                int customerId = rs.getInt("customer_id");
                LocalDate createdDate = LocalDate.parse(rs.getString("created_date"));
                int period = rs.getInt("period");
                boolean hasDeliveryInsurance = rs.getInt("has_delivery_insurance") != 0;
                boolean hasLowDeductableInsurance = rs.getInt("has_low_deductable_insurance") != 0;
                int pickupLocationId = rs.getInt("pickup_location_id");
                boolean isLimited = rs.getInt("is_limited") != 0;
                int price = rs.getInt("price");
                LocalDate startDate = LocalDate.parse(rs.getString("start_date"));
                leaseReports.add(new LeaseReport(id, carId, employeeId, customerId, createdDate, period, hasDeliveryInsurance, hasLowDeductableInsurance, pickupLocationId, isLimited, price, startDate));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return leaseReports;
    }

    @Override
    public LeaseReport getSingleById(int id) {
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM leasing_report WHERE lease_report_id = '"+id+"'");
            rs.next();

            int leaseReportId = rs.getInt("lease_report_id");
            int carId = rs.getInt("car_id");
            int employeeId = rs.getInt("employee_id");
            int customerId = rs.getInt("customer_id");
            LocalDate createdDate = LocalDate.parse(rs.getString("created_date"));
            int period = rs.getInt("period");
            boolean hasDeliveryInsurance = rs.getInt("has_delivery_insurance") != 0;
            boolean hasLowDeductableInsurance = rs.getInt("has_low_deductable_insurance") != 0;
            int pickupLocationId = rs.getInt("pickup_location_id");
            boolean isLimited = rs.getInt("is_limited") != 0;
            int price = rs.getInt("price");
            LocalDate startDate = LocalDate.parse(rs.getString("start_date"));

            return new LeaseReport(leaseReportId, carId, employeeId, customerId, createdDate, period, hasDeliveryInsurance, hasLowDeductableInsurance, pickupLocationId, isLimited, price, startDate);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(LeaseReport entity) {
        int leaseReportId = entity.getId();
        int carId = entity.getCarId();
        int employeeId = entity.getEmployeeId();
        int customerId = entity.getCustomerId();
        LocalDate createdDate = entity.getCreatedDate();
        int period = entity.getPeriod();
        int hasDeliveryInsurance = entity.hasReturnInsurance() ? 1 : 0;
        int hasLowDeductableInsurance = entity.hasLowDeductableInsurance() ? 1 : 0;
        int pickupLocation = entity.getPickupLocationId();
        int isLimited = entity.isLimited() ? 1 : 0;
        double price = entity.getPrice();
        LocalDate startDate = entity.getStartDate();

        String query = "SELECT * FROM leasing_report AS l WHERE l.lease_report_id = '" + leaseReportId + "'";

        String query2 = "UPDATE employees SET " +
                "car_id='" + carId + "' , " +
                "employee_id='" + employeeId + "' , " +
                "costumer_id='" + customerId + "' , " +
                "created_date='" + createdDate + "' ," +
                "period='" + period + "' ," +
                "has_delivery_insurance='" + hasDeliveryInsurance + "' ," +
                "has_low_deductable_insurance='" + hasLowDeductableInsurance + "' ," +
                "pickup_location_id='" + pickupLocation + "' ," +
                "is_limited='" + isLimited + "' ," +
                "price='" + price + "' ," +
                "start_date='" + startDate + "'" +
                "WHERE lease_report_id='" + leaseReportId + "'";
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
        String query = "DELETE FROM leasing_report WHERE lease_report_id='"+id+"';";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
