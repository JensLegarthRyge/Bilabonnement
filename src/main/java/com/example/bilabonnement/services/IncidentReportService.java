package com.example.bilabonnement.services;

import com.example.bilabonnement.models.IncidentReport;
import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.IncidentReportRepository;

import java.util.ArrayList;


public class IncidentReportService {

    /*Jens Legarth Ryge*/
    LeaseReportService lrs = new LeaseReportService();
    public ArrayList<IncidentReport> getActiveIncidentReports(){
        //Removes irrelevant incident reports
        ArrayList<Integer> allActiveLeaseReportIds = new ArrayList<>();

        for (LeaseReport clr:lrs.getActiveLeaseReports()) {
            allActiveLeaseReportIds.add(clr.getId());
        }

        IncidentReportRepository incidentReportRepository = new IncidentReportRepository();
        ArrayList<IncidentReport> allIncidentReports = incidentReportRepository.getAll();

        allIncidentReports.removeIf(currentIncidentReport ->
                !allActiveLeaseReportIds.contains(currentIncidentReport.getLeaseReportId())
        );
        return allIncidentReports;
    }
}
