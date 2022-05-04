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
}
