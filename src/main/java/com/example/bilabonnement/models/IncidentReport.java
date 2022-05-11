package com.example.bilabonnement.models;

//Jens Legarth Ryge

import java.time.LocalDate;
import java.util.ArrayList;

public class IncidentReport {
    private int id;
    private int leaseReportId;
    private double price;
    private double customerPrice;

    public IncidentReport(int id, int leaseReportId, double price, double customerPrice){
        this.id = id;
        this.leaseReportId = leaseReportId;
        this.price = price;
        this.customerPrice = customerPrice;
    }

    public IncidentReport(int leaseReportId){
        this.leaseReportId = leaseReportId;
    }

    public int getId() {
        return id;
    }

    public int getLeaseReportId() {
        return leaseReportId;
    }


    public double getPrice() {
        return price;
    }

    public double getCustomerPrice() {
        return customerPrice;
    }
}
