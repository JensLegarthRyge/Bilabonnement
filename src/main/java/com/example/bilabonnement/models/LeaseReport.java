package com.example.bilabonnement.models;

import java.time.LocalDate;

//Jens Legarth Ryge

public class LeaseReport {
    private int id;
    private String registrationId;
    private int incidentReportId;
    private Employee createdBy;
    private Customer rentedBy;
    private LocalDate createdDate;
    private int period;
    private boolean hasReturnInsurance;
    private boolean hasLowDeductableInsurance;
    private String pickupAddress;
    private boolean isLimited;
    private double price;
    private LocalDate startDate;

    public LeaseReport(int id, String registrationId, int incidentReportId, Employee createdBy, Customer rentedBy, LocalDate createdDate, int period, boolean hasReturnInsurance, boolean hasLowDeductableInsurance, String pickupAddress, boolean isLimited, double price, LocalDate startDate) {
        this.id = id;
        this.registrationId = registrationId;
        this.incidentReportId = incidentReportId;
        this.createdBy = createdBy;
        this.rentedBy = rentedBy;
        this.createdDate = createdDate;
        this.period = period;
        this.hasReturnInsurance = hasReturnInsurance;
        this.hasLowDeductableInsurance = hasLowDeductableInsurance;
        this.pickupAddress = pickupAddress;
        this.isLimited = isLimited;
        this.price = price;
        this.startDate = startDate;
    }

    public LeaseReport(String registrationId, int incidentReportId, Employee createdBy, Customer rentedBy, LocalDate createdDate, int period, boolean hasReturnInsurance, boolean hasLowDeductableInsurance, String pickupAddress, boolean isLimited, double price, LocalDate startDate) {
        this.registrationId = registrationId;
        this.incidentReportId = incidentReportId;
        this.createdBy = createdBy;
        this.rentedBy = rentedBy;
        this.createdDate = createdDate;
        this.period = period;
        this.hasReturnInsurance = hasReturnInsurance;
        this.hasLowDeductableInsurance = hasLowDeductableInsurance;
        this.pickupAddress = pickupAddress;
        this.isLimited = isLimited;
        this.price = price;
        this.startDate = startDate;
    }

    public LeaseReport(String registrationId, Employee createdBy, Customer rentedBy, int period, boolean hasReturnInsurance, boolean hasLowDeductableInsurance, String pickupAddress, boolean isLimited, double price, LocalDate startDate) {
        this.registrationId = registrationId;
        this.createdBy = createdBy;
        this.rentedBy = rentedBy;
        this.period = period;
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

    public String getRegistrationId() {
        return registrationId;
    }

    public int getIncidentReportId() {
        return incidentReportId;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public Customer getRentedBy() {
        return rentedBy;
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
