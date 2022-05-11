package com.example.bilabonnement.models;

import com.example.bilabonnement.repositories.CarRepository;
import com.example.bilabonnement.repositories.testRepositories.CarTestRepository;

import java.time.LocalDate;

//Jens Legarth Ryge

public class LeaseReport {
    private int id;
    private int carId;
    private int employeeId;
    private int customerId;
    private LocalDate createdDate;
    private int period;
    private boolean hasReturnInsurance;
    private boolean hasLowDeductableInsurance;
    private String pickupAddress;
    private boolean isLimited;
    private double price;
    private LocalDate startDate;

    public LeaseReport(int id, int carId, int employeeId, int customerId, LocalDate createdDate, int period, boolean hasReturnInsurance, boolean hasLowDeductableInsurance, String pickupAddress, boolean isLimited, double price, LocalDate startDate) {
        this.id = id;
        this.carId = carId;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.createdDate = createdDate;
        this.period = period;
        this.hasReturnInsurance = hasReturnInsurance;
        this.hasLowDeductableInsurance = hasLowDeductableInsurance;
        this.pickupAddress = pickupAddress;
        this.isLimited = isLimited;
        this.price = price;
        this.startDate = startDate;
    }

    //Bruges til at oprette nye leasereports
    public LeaseReport(int carId, int customerId, int employeeId, int period, boolean hasReturnInsurance, boolean hasLowDeductableInsurance, boolean isLimited, String pickupAddress, LocalDate startDate){
        this.carId = carId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.pickupAddress = pickupAddress;
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


        //this.id = skal auto incrementes i SQL
        //this.incidentReportId = skal laves mens denne bliver lavet.



    }

    public double getCarPrice(int carId){
        CarRepository carRep = new CarRepository();
        CarTestRepository carTestRep = new CarTestRepository();
        //double carPrice = carRep.getSingleById(carId).getPrice();
        double carPrice = carTestRep.getSingleById(1).getPrice();
        return carPrice;
    }


    public LeaseReport(int carId, int employeeId, int customerId, int period, boolean hasReturnInsurance, boolean hasLowDeductableInsurance, String pickupAddress, boolean isLimited, double price, LocalDate createdDate, LocalDate startDate) {
        this.carId = carId;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.period = period;
        this.hasReturnInsurance = hasReturnInsurance;
        this.hasLowDeductableInsurance = hasLowDeductableInsurance;
        this.pickupAddress = pickupAddress;
        this.isLimited = isLimited;
        this.price = price;
        this.createdDate = createdDate;
        this.startDate = startDate;
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

    public String getPickupAddress() {
        return pickupAddress;
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
                ", pickupAddress='" + pickupAddress + '\'' +
                ", isLimited=" + isLimited +
                ", price=" + price +
                ", startDate=" + startDate +
                '}';
    }
}
