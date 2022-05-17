package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.IncidentReport;
import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.CarRepository;
import com.example.bilabonnement.repositories.IncidentReportRepository;
import com.example.bilabonnement.repositories.LeaseReportRepository;

import java.time.LocalDate;
import java.util.ArrayList;

/*Jens Legarth Ryge*/

public class businessDevelopmentService {


    public String getCarsRentedAmount(){
        CarRepository carRepository = new CarRepository();
        ArrayList<Car> allCars = carRepository.getAll();
        int carsRented = 0;
        for (Car currentCar:allCars) {
            if (currentCar.isCurrentlyRented()){
                carsRented++;
            }
        }
        return carsRented+"/"+allCars.size();
    }

    public static void getEarningsAmount(){

        //Removes inactive lease reports
        LeaseReportRepository leaseReportRepository = new LeaseReportRepository();
        ArrayList<LeaseReport> allLeaseReports = leaseReportRepository.getAll();
        ArrayList<Integer> allActiveLeaseReportIds = new ArrayList<>();
        for (LeaseReport currentLeaseReport:allLeaseReports) {
            LocalDate leaseReportStartDate = currentLeaseReport.getStartDate();
            int period = currentLeaseReport.getPeriod();
            if (leaseReportStartDate.plusDays(period).isAfter(LocalDate.now())
                    || leaseReportStartDate.isBefore(LocalDate.now())){
                allLeaseReports.remove(currentLeaseReport);
                allActiveLeaseReportIds.add(currentLeaseReport.getId());
            }
        }

        //Removes irrelevant incident reports
        IncidentReportRepository incidentReportRepository = new IncidentReportRepository();
        ArrayList<IncidentReport> allIncidentReports = incidentReportRepository.getAll();
        allIncidentReports.removeIf(currentIncidentReport ->
                        !allActiveLeaseReportIds.contains(currentIncidentReport.getLeaseReportId())
        );

        double pureRentalEarnings = 0;
        for (LeaseReport currentLeaseReport:allLeaseReports) {
            pureRentalEarnings += currentLeaseReport.getPrice()/30.437 * currentLeaseReport.getPeriod();
        }

        double damageEarnings = 0;
        for (IncidentReport currentIncidentReport:allIncidentReports) {
            damageEarnings += currentIncidentReport.getPrice();
        }




    }
}
