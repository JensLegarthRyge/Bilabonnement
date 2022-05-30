package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.*;
import com.example.bilabonnement.services.LeaseReportService;
import com.example.bilabonnement.services.LoginService;


import com.example.bilabonnement.services.CSVFileService;
import com.example.bilabonnement.services.ModelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.time.LocalDate;

//Jens Legarth Ryge, Johannes Forsting og Mads Bøgh Højer Nielsen

@Controller
public class DataRegistrationController {
    ModelService ms = new ModelService();
    LoginService ls = new LoginService();
    LeaseReportService lrs = new LeaseReportService();

    @GetMapping("/data-registration")
    public String dataRegistration(HttpSession session, Model model) {
        if(!ls.hasAccess("data", (int) (session.getAttribute("accessFeatures")))){
            return "redirect:/no-access";
        }
        ms.fillModel(model);
        return "data-registration";
    }

    @PostMapping("/edit-lease-report")
    public String editLeaseReport(WebRequest dataFromForm, Model model) {
        int id = Integer.parseInt(dataFromForm.getParameter("edit-lease-id"));
        ms.insertLease(model, id);
        ms.fillModel(model);
        return "/data-registration-edit";
    }
    @PostMapping("/edit-lease-update")
    public String updateLease(HttpSession session, WebRequest dataFromForm) {
        lrs.uploadUpdatedLease(dataFromForm);
        return "redirect:/data-registration";
    }


    @PostMapping("/get-upload")
    public String getUpload(@RequestParam("registration-file") MultipartFile file) throws IOException {
        CSVFileService.writeDataToFile(file);

        return "redirect:/data-registration";
    }

    @PostMapping("/manual-upload")
    public String manualUpload(HttpSession session, WebRequest dataFromForm){
        int x = Integer.parseInt(session.getAttribute("userId").toString());
        lrs.uploadManualLease(dataFromForm, x);
        return "redirect:/data-registration";
    }

    @RequestMapping("delete-lease-report")
    public String tester(HttpSession session, WebRequest dataFromForm){
        int leaseReportId = Integer.parseInt(dataFromForm.getParameter("leaseId"));
        lrs.removeLeaseReport(leaseReportId);
        return "redirect:/data-registration";
    }

}
