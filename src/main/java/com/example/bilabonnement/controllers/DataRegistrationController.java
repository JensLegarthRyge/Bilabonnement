package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.repositories.testRepositories.CarTestRepository;
import com.example.bilabonnement.repositories.testRepositories.LeaseTestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class DataRegistrationController {

    @GetMapping("/data-registration")
    public String dataRegistration(HttpSession session, Model leaseModel) {
        //TEST REPLACE FOR PROD
        LeaseTestRepository lrt = new LeaseTestRepository();


        leaseModel.addAttribute("allLeaseReports",lrt.getAll());

        return "data-registration";
    }

    @PostMapping("/get-upload")
    public String getUpload(WebRequest uploadRequest){
        System.out.println(uploadRequest.getParameter("registration-file"));
        return "redirect:/data-registration";
    }


}
