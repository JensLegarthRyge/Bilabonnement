package com.example.bilabonnement.models;

import com.example.bilabonnement.repositories.CarRepository;
import com.example.bilabonnement.repositories.testRepositories.CarTestRepository;

import java.time.LocalDate;

//Jens Legarth Ryge & Johannes Forsting

public class LeaseReport {
    private int id;
    private int carId;
    private int employeeId;
    private int customerId;
    private LocalDate createdDate;
    private int period;
    private boolean hasReturnInsurance;
    private boolean hasLowDeductableInsurance;
    private int pickupLocationId;
    private boolean isLimited;
    private double price;
    private LocalDate startDate;

    public LeaseReport(int id, int carId, int employeeId, int customerId, LocalDate createdDate, int period, boolean hasReturnInsurance, boolean hasLowDeductableInsurance, int pickupLocationId, boolean isLimited, double price, LocalDate startDate) {
        this.id = id;
        this.carId = carId;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.createdDate = createdDate;
        this.period = period;
        this.hasReturnInsurance = hasReturnInsurance;
        this.hasLowDeductableInsurance = hasLowDeductableInsurance;
        this.pickupLocationId = pickupLocationId;
        this.isLimited = isLimited;
        this.price = price;
        this.startDate = startDate;
    }

    //Bruges til at oprette nye leasereports
    public LeaseReport(int carId, int customerId, int employeeId, int period, boolean hasReturnInsurance, boolean hasLowDeductableInsurance, boolean isLimited, int pickupLocationId, LocalDate startDate){
        this.carId = carId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.pickupLocationId = pickupLocationId;
        this.startDate = startDate;
        this.isLimited = isLimited;
        this.createdDate = LocalDate.now();
        this.price = getCarPrice(carId);
        if(isLimited){
            this.period = 120;
            this.hasLowDeductableInsurance = false;
            this.hasReturnInsurance = false;
        }
        else {
            this.period = period;
            this.hasReturnInsurance = hasReturnInsurance;
            this.hasLowDeductableInsurance = hasLowDeductableInsurance;
        }
        if(hasLowDeductableInsurance){
            price += 64;
        }
        if(hasReturnInsurance){
            price += 119;
        }
    }


    public LeaseReport(int carId, int employeeId, int customerId, int period, boolean hasReturnInsurance, boolean hasLowDeductableInsurance, int pickupLocationId, boolean isLimited, double price, LocalDate createdDate, LocalDate startDate) {
        this.carId = carId;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.period = period;
        this.hasReturnInsurance = hasReturnInsurance;
        this.hasLowDeductableInsurance = hasLowDeductableInsurance;
        this.pickupLocationId = pickupLocationId;
        this.isLimited = isLimited;
        this.price = price;
        this.createdDate = createdDate;
        this.startDate = startDate;
    }

    //Tager fra en bil fra testrepository lige nu.
    public double getCarPrice(int carId){
        CarRepository carRep = new CarRepository();
        CarTestRepository carTestRep = new CarTestRepository();
        //double carPrice = carRep.getSingleById(carId).getPrice();
        double carPrice = carTestRep.getSingleById(1).getPrice();
        return carPrice;
    }


    public int getId() {
        return id;
    }

    public int getCarId() {
        return carId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public int getPeriod() {
        return period;
    }

    public boolean hasReturnInsurance() {
        return hasReturnInsurance;
    }

    public boolean hasLowDeductableInsurance() {
        return hasLowDeductableInsurance;
    }

    public int getPickupLocationId() {
        return pickupLocationId;
    }

    public boolean isLimited() {
        return isLimited;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return "LeaseReport{" +
                "id=" + id +
                ", carId=" + carId +
                ", employeeId=" + employeeId +
                ", customerId=" + customerId +
                ", createdDate=" + createdDate +
                ", period=" + period +
                ", hasReturnInsurance=" + hasReturnInsurance +
                ", hasLowDeductableInsurance=" + hasLowDeductableInsurance +
                ", pickupAddress='" + pickupLocationId + '\'' +
                ", isLimited=" + isLimited +
                ", price=" + price +
                ", startDate=" + startDate +
                '}';
    }
}
