package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;
import org.slf4j.spi.LocationAwareLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

//Jens Legarth Ryge

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
        String pickupAdress = entity.getPickupAddress();
        int isLimited = entity.isLimited() ? 1 : 0;
        double price = entity.getPrice();
        LocalDate startDate = entity.getStartDate();

        String query = "INSERT INTO `bilabonnement`.`leasing_report` (`car_Id`, `employee_id`, `customer_id`, `created_date`, `period`, `has_delivery_insurance`, `has_low_deductable_insurance`, `pickup_adress`, `is_limited`, `price`, `start_date`) " +
                "VALUES ('"+carId+"', '"+employeeId+"', '"+customerId+"', '"+createdDate+"', '"+period+"', '"+hasDeliveryInsurance+"', '"+hasLowDeductableInsurance+"', '"+pickupAdress+"', '"+isLimited+"', '"+price+"', '"+startDate+"');";
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
