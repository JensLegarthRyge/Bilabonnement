package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.Enum.EnergyLabel;
import com.example.bilabonnement.models.Enum.FuelType;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;
import java.sql.*;
import java.util.ArrayList;

//Jens Legarth Ryge & Mads Bøgh Højer Nielsen

public class CarRepository implements CRUDInterface<Car> {
    Connection connection = DatabaseConnectionManager.getConnection();

    @Override
    public boolean create(Car entity) {

        String regNum = entity.getRegistrationNumber();
        String chaNum = entity.getChassisNumber();
        int isCurrentlyRented;
        if (entity.isCurrentlyRented()) {
            isCurrentlyRented = 1;
        } else {
            isCurrentlyRented = 0;
        }
        int isManual;
        if (entity.isManual()) {
           isManual = 1;
        } else {
            isManual = 0;
        }
        String fuelType = String.valueOf(entity.getFuelType());
        double fuelConsumption = entity.getFuelConsumptionPerKilometer();
        String energyLabel = String.valueOf(entity.getEnergyLabel());
        String color = entity.getColor();
        double price = entity.getPrice();
        int horsePower = entity.getHorsePower();
        double incidentFactor = entity.getIncidentFactor();

        String query = "INSERT INTO `bilabonnement`.`cars` (`registration_number`, `chassis_number`, `is_rented`, `is_manual`, `fuel_type`, `fuel_consumption`, `energy_label`, `color`, `price`, `horse_power`, `incident_factor`) " +
            " VALUES ('"+regNum+"', '"+chaNum+"', '"+isCurrentlyRented+"', '"+isManual+"', '"+fuelType+"', '"+fuelConsumption+"', '"+energyLabel+"', '"+color+"', '"+price+"', '"+horsePower+"', '"+incidentFactor+"');";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.executeUpdate();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

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
                boolean isCurrentlyRented = Car.convert(rs.getInt("is_rented"));
                boolean isManual = Car.convert(rs.getInt("is_manual"));
                FuelType fuelType = FuelType.valueOf(rs.getString("fuel_type"));
                double fuelConsumption = rs.getDouble("fuel_consumption");
                EnergyLabel energyLabel = EnergyLabel.valueOf(rs.getString("energy_label"));
                String color = rs.getString("color");
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
            rs.next();

            int carID = rs.getInt("car_id");
            String regNum = rs.getString("registration_number");
            String chaNum = rs.getString("chassis_number");
            boolean isCurrentlyRented = Car.convert(rs.getInt("is_rented"));
            boolean isManual = Car.convert(rs.getInt("is_manual"));
            FuelType fuelType = FuelType.valueOf(rs.getString("fuel_type"));
            double fuelConsumption = rs.getDouble("fuel_consumption");
            EnergyLabel energyLabel = EnergyLabel.valueOf(rs.getString("energy_label"));
            String color = rs.getString("color");
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
        int id = entity.getId();
        String regNum = entity.getRegistrationNumber();
        String chaNum = entity.getChassisNumber();
        int isCurrentlyRented;
        if (entity.isCurrentlyRented()) {
            isCurrentlyRented = 1;
        } else {
            isCurrentlyRented = 0;
        }
        int isManual;
        if (entity.isManual()) {
            isManual = 1;
        } else {
            isManual = 0;
        }
        String fuelType = String.valueOf(entity.getFuelType());
        double fuelConsumption = entity.getFuelConsumptionPerKilometer();
        String energyLabel = String.valueOf(entity.getEnergyLabel());
        String color = entity.getColor();
        double price = entity.getPrice();
        int horsePower = entity.getHorsePower();
        double incidentFactor = entity.getIncidentFactor();

        String query = "SELECT * FROM cars AS e WHERE e.car_id = '" + id + "'";

        String query2 = "UPDATE cars SET registration_number='" + regNum + "' , " +
                "chassis_number='" + chaNum + "' , " +
                "is_rented='" + isCurrentlyRented + "' , " +
                "is_manual='" + isManual + "' , " +
                "fuel_type='" + fuelType + "' ," +
                "fuel_consumption='" + fuelConsumption + "' , " +
                "energy_label='" + energyLabel + "' , " +
                "color='" + color + "' , " +
                "price='" + price + "' , " +
                "horse_power='" + horsePower + "' , " +
                "incident_factor='" + incidentFactor + "'" +
                "WHERE car_id='" + id + "'";
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
        String query = "DELETE FROM cars WHERE car_id='"+id+"';";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getCarByChassisNumber (String chassisNumber) {
        int carId = 0;
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM cars WHERE chassis_number = '"+chassisNumber+"'");
            rs.next();

            carId = rs.getInt("car_id");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carId;

    }
}
