package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Incident;
import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.IncidentReportRepository;
import com.example.bilabonnement.repositories.IncidentRepository;
import com.example.bilabonnement.repositories.LeaseReportRepository;

import java.time.LocalDate;
import java.util.ArrayList;



public class LeaseReportService {

    /*Jens Legarth Ryge*/
    LeaseReportRepository leaseReportRepository = new LeaseReportRepository();
    IncidentReportRepository irr = new IncidentReportRepository();
    public ArrayList<LeaseReport> getActiveLeaseReports(){
        //Removes inactive lease reports
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


    public void removeLeaseReport(int id){

        int incidentReportId = irr.getSpecificByLeaseReportId(id).getId();
        removeIncidentReport(incidentReportId);
        leaseReportRepository.delete(id);

    }

    public void removeIncidentReport(int id){
        removeIncidents(id);
        irr.delete(id);
    }

    public void removeIncidents(int id){
        IncidentRepository ir = new IncidentRepository();
        ArrayList<Incident> incidents = ir.getALlSpecific(id);
        for (int i = 0; i < incidents.size(); i++) {
            ir.delete(incidents.get(i).getId());
        }
    }
}
