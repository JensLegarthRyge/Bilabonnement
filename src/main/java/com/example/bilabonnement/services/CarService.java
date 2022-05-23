package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.CarRepository;

import java.util.ArrayList;

public class CarService {
    public void updateRentalStatus(){
        LeaseReportService leaseReportService = new LeaseReportService();
        CarRepository carRepository = new CarRepository();

        ArrayList<LeaseReport> activeLeaseReports = leaseReportService.getActiveLeaseReports();
        ArrayList<Integer> rentedCarIds = new ArrayList<>();

        for (LeaseReport currentLeaseReport:activeLeaseReports) {
            rentedCarIds.add(currentLeaseReport.getCarId());
            System.out.println(currentLeaseReport.getId());
        }

        for (Car currentCar:carRepository.getAll()) {
            currentCar.setCurrentlyRented(rentedCarIds.contains(currentCar.getId()));
            carRepository.update(currentCar);
        }
    }
}
