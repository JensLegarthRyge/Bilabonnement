package com.example.bilabonnement.models;

import com.example.bilabonnement.models.Enum.EnergyLabel;
import com.example.bilabonnement.models.Enum.FuelType;

//Jens Legarth Ryge

public class Car {
    private int id;
    private String registrationNumber;
    private String chassisNumber;
    private boolean isCurrentlyRented;
    private boolean isManual;
    private FuelType fuelType;
    private double fuelConsumptionPerKilometer;
    private EnergyLabel energyLabel;
    private String color;
    private double price;
    private int horsePower;
    private double incidentFactor;

    public Car(String registrationNumber, String chassisNumber, boolean isCurrentlyRented, boolean isManual, FuelType fuelType, double fuelConsumptionPerKilometer, EnergyLabel energyLabel, String color, double price, int horsePower, double incidentFactor) {
        this.registrationNumber = registrationNumber;
        this.chassisNumber = chassisNumber;
        this.isCurrentlyRented = isCurrentlyRented;
        this.isManual = isManual;
        this.fuelType = fuelType;
        this.fuelConsumptionPerKilometer = fuelConsumptionPerKilometer;
        this.energyLabel = energyLabel;
        this.color = color;
        this.price = price;
        this.horsePower = horsePower;
        this.incidentFactor = incidentFactor;
    }

    public Car(int id, String registrationNumber, String chassisNumber, boolean isCurrentlyRented, boolean isManual, FuelType fuelType, double fuelConsumptionPerKilometer, EnergyLabel energyLabel, String color, double price, int horsePower, double incidentFactor) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.chassisNumber = chassisNumber;
        this.isCurrentlyRented = isCurrentlyRented;
        this.isManual = isManual;
        this.fuelType = fuelType;
        this.fuelConsumptionPerKilometer = fuelConsumptionPerKilometer;
        this.energyLabel = energyLabel;
        this.color = color;
        this.price = price;
        this.horsePower = horsePower;
        this.incidentFactor = incidentFactor;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", isCurrentlyRented=" + isCurrentlyRented +
                ", isManual=" + isManual +
                ", fuelType=" + fuelType +
                ", fuelConsumptionPerKilometer=" + fuelConsumptionPerKilometer +
                ", energyLabel=" + energyLabel +
                ", color=" + color +
                ", price=" + price +
                ", horsePower=" + horsePower +
                ", incidentFactor=" + incidentFactor +
                '}';
    }

    public static boolean convert (int status) {

        if (status == 1) {
            return true;
        } else {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }


    public String getChassisNumber() {
        return chassisNumber;
    }

    public boolean isCurrentlyRented() {
        return isCurrentlyRented;
    }

    public void setCurrentlyRented(boolean currentlyRented) {
        isCurrentlyRented = currentlyRented;
    }

    public boolean isManual() {
        return isManual;
    }


    public FuelType getFuelType() {
        return fuelType;
    }

    public double getFuelConsumptionPerKilometer() {
        return fuelConsumptionPerKilometer;
    }


    public EnergyLabel getEnergyLabel() {
        return energyLabel;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getHorsePower() {
        return horsePower;
    }


    public double getIncidentFactor() {
        return incidentFactor;
    }

}


