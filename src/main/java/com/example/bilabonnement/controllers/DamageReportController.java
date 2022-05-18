package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.Incident;
import com.example.bilabonnement.models.IncidentReport;
import com.example.bilabonnement.repositories.*;
import com.example.bilabonnement.services.IncidentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    IncidentTypeRepository itr = new IncidentTypeRepository();

    @GetMapping("/damage")
    public String damageAndMaintenance(HttpSession session, Model damageModel){
        ArrayList<IncidentReport> incidentReports = irr.getAll();
        session.setAttribute("incidentReportId", null);

        if(session.getAttribute("registrationNumber") != null){
            incidentReports = IncidentService.removeAllBut(incidentReports, session.getAttribute("registrationNumber").toString());
            session.setAttribute("registrationNumber", null);
        }
        damageModel.addAttribute("allIncidentReports",incidentReports);
        return "damage-and-maintenance";
    }

    @RequestMapping("/report")
    public String damageReport(HttpSession session, Model leaseReport, Model incidentsOnReport, Model incidentReport, Model customer, Model incidentTypes, WebRequest dataFromForm){
        if(session.getAttribute("incidentReportId") == null){
            session.setAttribute("incidentReportId", Integer.parseInt(dataFromForm.getParameter("id")));
        }
        int incidentReportId = (int)session.getAttribute("incidentReportId");
        customer.addAttribute("customer", cr.getSingleById(lr.getSingleById(irr.getSingleById(incidentReportId).getLeaseReportId()).getCustomerId()));
        leaseReport.addAttribute("leaseReport", lr.getSingleById(irr.getSingleById(incidentReportId).getLeaseReportId()));
        incidentReport.addAttribute("incidentReport", irr.getSingleById(incidentReportId));
        ArrayList<Incident> incidents1 = ir.getALlSpecific(incidentReportId);
        incidentsOnReport.addAttribute("incidents", incidents1);
        incidentTypes.addAttribute("incidentTypes", itr.getAll());

        return "damage-report";
    }

    @PostMapping("delete-incident")
    public String deleteIncident(WebRequest dataFromForm){
        IncidentService incidentService = new IncidentService();
        incidentService.deleteIncident(dataFromForm);
        return "redirect:/report";
    }

    @PostMapping("create-incident")
    public String createIncident(HttpSession session, WebRequest dataFromForm){
        IncidentService incidentService = new IncidentService();
        incidentService.createNewIncident(dataFromForm);
        System.out.println(dataFromForm.toString());
        return "redirect:/report";
    }


    @PostMapping("search")
    public String search(HttpSession session, WebRequest dataFromForm){
        if(dataFromForm.getParameter("clear") != null){
            return "redirect:/damage";
        }
        session.setAttribute("registrationNumber", dataFromForm.getParameter("search"));
        return "redirect:/damage";
    }
}
