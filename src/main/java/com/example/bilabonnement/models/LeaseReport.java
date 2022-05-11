package com.example.bilabonnement.models;

import java.time.LocalDate;

//Jens Legarth Ryge

public class LeaseReport {
    private int id;
    private int carID;
    private int incidentReportId;
    private int employeeID;
    private int customerID;
    private LocalDate createdDate;
    private int period;
    private boolean hasReturnInsurance;
    private boolean hasLowDeductableInsurance;
    private String pickupAddress;
    private boolean isLimited;
    private double price;
    private LocalDate startDate;

    public LeaseReport(int id, int carID, int incidentReportId, int employeeID, int customerID, LocalDate createdDate, int period, boolean hasReturnInsurance, boolean hasLowDeductableInsurance, String pickupAddress, boolean isLimited, double price, LocalDate startDate) {
        this.id = id;
        this.carID = carID;
        this.incidentReportId = incidentReportId;
        this.employeeID = employeeID;
        this.customerID = customerID;
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
    public LeaseReport(int carID, int customerID, int employeeID, int period, boolean hasReturnInsurance, boolean hasLowDeductableInsurance, boolean isLimited, String pickupAddress, LocalDate startDate){
        this.carID = carID;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.hasReturnInsurance = hasReturnInsurance;
        this.hasLowDeductableInsurance = hasLowDeductableInsurance;
        this.pickupAddress = pickupAddress;
        this.startDate = startDate;
        this.isLimited = isLimited;
        this.createdDate = LocalDate.now();
        if(isLimited){
            this.period = 120;
        }
        else {
            this.period = period;
        }
        //this.id = skal auto incrementes i SQL
        //this.createdBy = fra seesion skal denne findes
        //this.incidentReport = skal laves mens denne bliver lavet.
        //this.price skal beregnes afhængig af bil og forsikring osv.





    }


    public LeaseReport(int carID, int employeeID, int customerID, int period, boolean hasReturnInsurance, boolean hasLowDeductableInsurance, String pickupAddress, boolean isLimited, double price, LocalDate startDate) {
        this.carID = carID;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.hasReturnInsurance = hasReturnInsurance;
        this.hasLowDeductableInsurance = hasLowDeductableInsurance;
        this.pickupAddress = pickupAddress;
        this.isLimited = isLimited;
        this.price = price;
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public int getCarID() {
        return carID;
    }

    public int getIncidentReportId() {
        return incidentReportId;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public int getCustomerID() {
        return customerID;
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
}
