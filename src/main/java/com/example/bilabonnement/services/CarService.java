package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.CarRepository;

import java.util.ArrayList;

public class CarService {
    LeaseReportService lrs = new LeaseReportService();
    CarRepository cr = new CarRepository();
    public void updateRentalStatus(){
        ArrayList<LeaseReport> activeLeaseReports = lrs.getActiveLeaseReports();
        ArrayList<Integer> rentedCarIds = new ArrayList<>();

        for (LeaseReport currentLeaseReport:activeLeaseReports) {
            rentedCarIds.add(currentLeaseReport.getCarId());
        }

        for (Car currentCar:cr.getAll()) {
            currentCar.setCurrentlyRented(rentedCarIds.contains(currentCar.getId()));
            cr.update(currentCar);
        }
    }
}
