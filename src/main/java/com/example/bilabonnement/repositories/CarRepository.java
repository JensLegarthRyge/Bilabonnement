package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.Enum.EnergyLabel;
import com.example.bilabonnement.models.Enum.FuelType;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

//Jens Legarth Ryge

public class CarRepository implements CRUDInterface<Car> {
    Connection connection = DatabaseConnectionManager.getConnection();
    @Override
    public boolean create(Car entity) {

        String regNum = entity.getRegistrationNumber();
        String chaNum = entity.getChassisNumber();
        boolean isCurrentlyRented = entity.isCurrentlyRented();
        boolean isManual = entity.isManual();
        FuelType fuelType = entity.getFuelType();
        double fuelConsumption = entity.getFuelConsumptionPerKilometer();
        EnergyLabel energyLabel = entity.getEnergyLabel();
        Color color = entity.getColor();
        double price = entity.getPrice();
        int horsePower = entity.getHorsePower();
        double incidentFactor = entity.getIncidentFactor();

        String query = "INSERT INTO `bilabonnement`.`cars` (`registration_number`, `chassis_number`, `is_rented`, `is_manual`, `fuel_type`, `km/l`, `energy_label`, `color`, `price`, `horse_power`, `incident_factor`)+" +
            " VALUES ('"+regNum+"', '"+chaNum+"', '"+isCurrentlyRented+"', '"+isManual+"', '"+fuelType+"', '"+fuelConsumption+"', '"+energyLabel+"', '"+color+"', '"+price+"', '"+horsePower+"', '"+incidentFactor+"');";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public ArrayList<Car> getAll() {
        ArrayList<Car> cars = new ArrayList<Car>();

        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM cars AS e WHERE e.car_id IS NOT NULL");
            while (rs.next()) {
                int carID = rs.getInt("car_id");
                String regNum = rs.getString("registration_number");
                String chaNum = rs.getString("chassis_number");
                boolean isCurrentlyRented = Car.convert(rs.getInt("is_rented")); //Needs to be boolean
                boolean isManual = Car.convert(rs.getInt("is_manual")); //Needs to be boolean
                FuelType fuelType = FuelType.valueOf(rs.getString("fuel_type"));
                double fuelConsumption = rs.getDouble("km/l");
                EnergyLabel energyLabel = EnergyLabel.valueOf(rs.getString("energy_label"));
                Color color = Color.decode(rs.getString("color"));
                double price = rs.getInt("price");
                int horsePower = rs.getInt("horse_power");
                double incidentFactor = rs.getDouble("incident_factor");

                cars.add(new Car(carID,regNum,chaNum,isCurrentlyRented,isManual,fuelType,fuelConsumption,energyLabel,color,price,horsePower,incidentFactor));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public Car getSingleById(int id) {
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM cars WHERE car_id = '"+id+"'");

            int carID = rs.getInt("car_id");
            String regNum = rs.getString("registration_number");
            String chaNum = rs.getString("chassis_number");
            boolean isCurrentlyRented = Car.convert(rs.getInt("is_rented")); //Needs to be boolean
            boolean isManual = Car.convert(rs.getInt("is_manual")); //Needs to be boolean
            FuelType fuelType = FuelType.valueOf(rs.getString("fuel_type"));
            double fuelConsumption = rs.getDouble("km/l");
            EnergyLabel energyLabel = EnergyLabel.valueOf(rs.getString("energy_label"));
            Color color = Color.decode(rs.getString("color"));
            double price = rs.getInt("price");
            int horsePower = rs.getInt("horse_power");
            double incidentFactor = rs.getDouble("incident_factor");

            return new Car(carID,regNum,chaNum,isCurrentlyRented,isManual,fuelType,fuelConsumption,energyLabel,color,price,horsePower,incidentFactor);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(Car entity) {

        return false;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM cars WHERE car_id='"+id+"';";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
