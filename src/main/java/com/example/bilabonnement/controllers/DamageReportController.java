package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.Incident;
import com.example.bilabonnement.models.IncidentReport;
import com.example.bilabonnement.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class DamageReportController {
    LeaseReportRepository lr = new LeaseReportRepository();
    IncidentRepository ir = new IncidentRepository();
    IncidentReportRepository irr = new IncidentReportRepository();
    CustomerRepository cr = new CustomerRepository();
    CarRepository carRepository = new CarRepository();

    @GetMapping("/damage")
    public String damageAndMaintenance(HttpSession session, Model damageModel){
        damageModel.addAttribute("allIncidentReports",irr.getAll());

        return "damage-and-maintenance";
    }

    @PostMapping("/report")
    public String damageReport(HttpSession session, Model leaseReport, Model incidents, Model incidentReport, Model customer, WebRequest dataFromForm){
        int incidentReportId = Integer.parseInt(dataFromForm.getParameter("id"));
        customer.addAttribute("customer", cr.getSingleById(lr.getSingleById(irr.getSingleById(incidentReportId).getLeaseReportId()).getCustomerId()));
        leaseReport.addAttribute("leaseReport", lr.getSingleById(irr.getSingleById(incidentReportId).getLeaseReportId()));
        incidentReport.addAttribute("incidentReport", irr.getSingleById(incidentReportId));
        ArrayList<Incident> incidents1 = ir.getALlSpecific(incidentReportId);
        System.out.println(incidents1);
        incidents.addAttribute("incidents", incidents1);

        return "damage-report";
    }

    @PostMapping("delete-incident")
    public String deleteIncident(){
        System.out.println("test");
        return "redirect:/damage-report";
    }
}
