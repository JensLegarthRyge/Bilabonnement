package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.Incident;
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

    @GetMapping("/damage")
    public String damageAndMaintenance(HttpSession session, Model damageModel){
        damageModel.addAttribute("allIncidentReports",irr.getAll());

        return "damage-and-maintenance";
    }

    @PostMapping("/report")
    public String damageReport(HttpSession session, Model report, Model incidents, WebRequest dataFromForm){
        int leaseReportId = Integer.parseInt(dataFromForm.getParameter("id"));
        report.addAttribute("report", lr.getSingleById(leaseReportId));

        incidents.addAttribute("incidents", ir.getALlSpecific(leaseReportId));

        return "damage-report";
    }
}
