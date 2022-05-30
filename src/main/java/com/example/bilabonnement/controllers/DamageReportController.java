package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.IncidentReport;
import com.example.bilabonnement.repositories.*;
import com.example.bilabonnement.services.IncidentReportService;
import com.example.bilabonnement.services.IncidentService;
import com.example.bilabonnement.services.LoginService;
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
    IncidentReportRepository irr = new IncidentReportRepository();
    LoginService ls = new LoginService();
    IncidentService is = new IncidentService();

    IncidentReportService irs = new IncidentReportService();

    @GetMapping("/damage")
    public String damageAndMaintenance(HttpSession session, Model damageModel){
        if(!ls.hasAccess("damage", (int) (session.getAttribute("accessFeatures")))){
            return "redirect:/no-access";
        }
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
    public String damageReport(HttpSession session, Model model, WebRequest dataFromForm){
        if(session.getAttribute("incidentReportId") == null){
            session.setAttribute("incidentReportId", Integer.parseInt(dataFromForm.getParameter("id")));
        }
        int incidentReportId = (int)session.getAttribute("incidentReportId");
        irs.getIncidentReportModel(incidentReportId, model);

        return "damage-report";
    }

    @PostMapping("delete-incident")
    public String deleteIncident(WebRequest dataFromForm){
        is.deleteIncident(dataFromForm);
        return "redirect:/report";
    }

    @PostMapping("create-incident")
    public String createIncident(HttpSession session, WebRequest dataFromForm){
        is.createNewIncident(dataFromForm);
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
