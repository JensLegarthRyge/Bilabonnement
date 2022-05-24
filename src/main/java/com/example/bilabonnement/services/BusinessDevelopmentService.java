package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.IncidentReport;
import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.CarRepository;

import java.util.ArrayList;
import java.util.Locale;


public class BusinessDevelopmentService {
    /*Jens Legarth Ryge*/
    CarRepository cr = new CarRepository();
    LeaseReportService lrs = new LeaseReportService();
    IncidentReportService irs = new IncidentReportService();
    public String getCarsRentedAmount(){

        ArrayList<Car> allCars = cr.getAll();
        int carsRented = 0;
        for (Car currentCar:allCars) {
            if (currentCar.isCurrentlyRented()){
                carsRented++;
            }
        }
        return carsRented+"/"+allCars.size();
    }

    public double getPureRentalEarnings() {
        double RentalEarnings = 0;
        for (LeaseReport currentLeaseReport : lrs.getActiveLeaseReports()) {
            RentalEarnings += (currentLeaseReport.getPrice() / 30.437) * currentLeaseReport.getPeriod();
        }
        return RentalEarnings;
    }

    public double getPureDamageEarnings(){
        double damageEarnings = 0;
        for (IncidentReport currentIncidentReport:irs.getActiveIncidentReports()) {
            damageEarnings += currentIncidentReport.getPrice();
        }
        return damageEarnings;
    }

    public double getTotalEarnings(){
        return getPureDamageEarnings()+getPureRentalEarnings();
    }

    public String valueToCurrencyString(double value){
        return String.format(Locale.GERMAN, "%,.2f", value) + " DKK";
    }


}
