package com.example.bilabonnement.models;

import com.example.bilabonnement.models.Enum.EnergyLabel;
import com.example.bilabonnement.models.Enum.FuelType;

import java.awt.*;

//Jens Legarth Ryge

public class Car {
    private String registrationId;
    private String chassisId;
    private boolean isCurrentlyRented;
    private boolean isManual;
    private FuelType fuelType;
    private double fuelConsumptionPerKilometer;
    private EnergyLabel energyLabel;
    private Color color;
    private double price;
    private int horsePower;
    private double incidentFactor;
}
