package com.example.bilabonnement.services;

import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.LeaseReportRepository;

import java.time.LocalDate;
import java.util.ArrayList;



public class LeaseReportService {

    /*Jens Legarth Ryge*/
    public ArrayList<LeaseReport> getActiveLeaseReports(){
        //Removes inactive lease reports
        LeaseReportRepository leaseReportRepository = new LeaseReportRepository();
        ArrayList<LeaseReport> allActiveLeaseReports = new ArrayList<>();


        for (LeaseReport currentLeaseReport:leaseReportRepository.getAll()) {

            LocalDate leaseReportStartDate = currentLeaseReport.getStartDate();
            int period = currentLeaseReport.getPeriod();

            if (!leaseReportStartDate.plusDays(period).isAfter(LocalDate.now())
                    || !leaseReportStartDate.isBefore(LocalDate.now())){
                allActiveLeaseReports.add(currentLeaseReport);
            }
        }
        return allActiveLeaseReports;
    }
}
