package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.repositories.CarRepository;
import com.example.bilabonnement.repositories.CustomerRepository;
import com.example.bilabonnement.repositories.EmployeeRepository;
import com.example.bilabonnement.repositories.testRepositories.LeaseTestRepository;
import com.example.bilabonnement.services.ManualUpload;
import com.opencsv.CSVWriter;

import com.example.bilabonnement.repositories.testRepositories.LeaseTestRepository;
import com.example.bilabonnement.services.CSVFileService;
import com.opencsv.CSVWriter;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

@Controller
public class DataRegistrationController {

    @GetMapping("/data-registration")
    public String dataRegistration(HttpSession session, Model leaseModel, Model idList) {
        //TEST REPLACE FOR PROD

        LeaseTestRepository lrt = new LeaseTestRepository();
        leaseModel.addAttribute("allLeaseReports",lrt.getAll());

        CustomerRepository cr = new CustomerRepository();
        CarRepository carRepo = new CarRepository();
        idList.addAttribute("allCars", carRepo.getAll());
        idList.addAttribute("allCustomers", cr.getAll());

        return "data-registration";
    }

    @PostMapping("/get-upload")
    public String getUpload(@RequestParam("registration-file") MultipartFile file) throws IOException {
        CSVFileService.writeDataToFile(file);

        return "redirect:/data-registration";
    }

    @PostMapping("/manual-upload")
    public String manualUpload(HttpSession session, WebRequest dataFromForm){
        ManualUpload manU = new ManualUpload();
        int x = Integer.parseInt(session.getAttribute("userId").toString());
        manU.uploadManualLease(dataFromForm, x);

        System.out.println(dataFromForm.getParameter("carId"));



        return "redirect:/data-registration";
    }

    @RequestMapping("/list")
    public String listOfId (HttpSession session, WebRequest dataFromForm, Model idList) {

        return "data-registration";
    }


}
