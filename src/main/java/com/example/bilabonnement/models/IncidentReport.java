package com.example.bilabonnement.models;

//Jens Legarth Ryge

import java.time.LocalDate;
import java.util.ArrayList;

public class IncidentReport {
    private int id;
    private int leaseReportId;
    private LocalDate date;
    private double price;
    private double customerPrice;

    public IncidentReport(int id, int leaseReportId, LocalDate date, double price, double customerPrice){
        this.id = id;
        this.leaseReportId = leaseReportId;
        this.date = date;
        this.price = price;
        this.customerPrice = customerPrice;
    }

    public IncidentReport(int leaseReportId){
        //Skal laves en constructor til at lave en ny INcident rapport. Price, customerprice og id skal oprettes automastisk.
        //Denne constructor skal kun laves når der laves en ny leasingReport
    }

}
