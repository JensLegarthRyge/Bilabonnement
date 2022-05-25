package com.example.bilabonnement.services;

import com.example.bilabonnement.models.IncidentReport;
import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.*;
import org.springframework.ui.Model;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;


public class IncidentReportService {

    /*Jens Legarth Ryge*/
    LeaseReportService lrs = new LeaseReportService();
    LeaseReportRepository lrr = new LeaseReportRepository();
    CustomerRepository cr = new CustomerRepository();
    IncidentReportRepository irr = new IncidentReportRepository();

    IncidentTypeRepository itr = new IncidentTypeRepository();
    IncidentRepository ir = new IncidentRepository();
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


    //Johannes Forsting
    public Model getIncidentReportModel(int incidentReportId, Model model){
        System.out.println(cr.getSingleById(lrr.getSingleById(irr.getSingleById(incidentReportId).getLeaseReportId()).getCustomerId()));
        model.addAttribute("customer", cr.getSingleById(lrr.getSingleById(irr.getSingleById(incidentReportId).getLeaseReportId()).getCustomerId()));
        model.addAttribute("leaseReport", lrr.getSingleById(irr.getSingleById(incidentReportId).getLeaseReportId()));
        model.addAttribute("incidentReport", irr.getSingleById(incidentReportId));
        model.addAttribute("incidents", ir.getALlSpecific(incidentReportId));
        model.addAttribute("incidentTypes", itr.getAll());
        return model;
    }
}
