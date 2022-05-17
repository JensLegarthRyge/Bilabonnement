package com.example.bilabonnement.models;

//Jens Legarth Ryge

import com.example.bilabonnement.repositories.CarRepository;
import com.example.bilabonnement.repositories.CustomerRepository;
import com.example.bilabonnement.repositories.IncidentRepository;
import com.example.bilabonnement.repositories.LeaseReportRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class IncidentReport {
    private int id;
    private int leaseReportId;
    private double price;
    private double customerPrice;

    static LeaseReportRepository lr = new LeaseReportRepository();
    static CarRepository cr = new CarRepository();
    static CustomerRepository cur = new CustomerRepository();

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

    public double calculatePrice() {
        IncidentRepository ir = new IncidentRepository();
        ArrayList<Incident> incidents = ir.getALlSpecific(this.id);
        for (Incident ci:incidents) {
            ci.getPrice()

        }
    }

    public double getCustomerPrice() {
        return customerPrice;
    }

    public String getRegistrationNumber(){
        int carId = lr.getSingleById(this.leaseReportId).getCarId();
        String registrationNumber = cr.getSingleById(carId).getRegistrationNumber();
        return registrationNumber;
    }

    public String getLeasedBy(){
        int customerId = lr.getSingleById(this.leaseReportId).getCustomerId();
        String customerName = cur.getSingleById(customerId).getFullName();
        return customerName;
    }

    public String getCreationDate(){
        String creationDate = lr.getSingleById(this.leaseReportId).getCreatedDate().toString();
        return creationDate;
    }

}
