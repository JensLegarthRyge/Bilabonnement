package com.example.bilabonnement.controllers;

import com.example.bilabonnement.repositories.*;
import com.example.bilabonnement.services.LeaseReportService;
import com.example.bilabonnement.services.ManualUpload;

import com.example.bilabonnement.services.CSVFileService;
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

@Controller
public class DataRegistrationController {

    @GetMapping("/data-registration")
    public String dataRegistration(HttpSession session, Model model) {
        // TODO: 5/11/2022  TEST REPLACE FOR PROD
        model.addAttribute("allLeaseReports",new LeaseReportRepository().getAll());
        model.addAttribute("allPickupLocations",new PickupLocationRepository().getAll());

        //Working, DO NOT REPLACE
        CustomerRepository customerRepository = new CustomerRepository();
        CarRepository carRepository = new CarRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        PickupLocationRepository pickupLocationRepository = new PickupLocationRepository();
        model.addAttribute("pickupLocationRepository", pickupLocationRepository);
        model.addAttribute("employeeRepository",employeeRepository);
        model.addAttribute("customerRepository",customerRepository);
        model.addAttribute("carRepository",carRepository);
        model.addAttribute("allCars", carRepository.getAll());
        model.addAttribute("allCustomers", customerRepository.getAll());

        LeaseReportRepository lr = new LeaseReportRepository();
        EmployeeRepository er = new EmployeeRepository();
        PickupLocationRepository pr = new PickupLocationRepository();



        if (lr.getSingleById(25).hasLowDeductableInsurance()) {
            model.addAttribute("hasDeductable", "Har afleveringsforsikring");
        } else {
            model.addAttribute("hasDeductable", "Har ikke afleveringsforsikring");
        }

        if (lr.getSingleById(25).hasReturnInsurance()) {
            model.addAttribute("hasReturn", "Har afleveringsforsikring");
        } else {
            model.addAttribute("hasReturn", "Har ikke afleveringsforsikring");
        }

        if (lr.getSingleById(25).isLimited()) {
            model.addAttribute("isLimited", "Limited");
        } else {
            model.addAttribute("isLimited", "Unlimited");
        }



        model.addAttribute("lease", lr.getSingleById(25));
        model.addAttribute("allCars", carRepository.getAll());
        model.addAttribute("allCustomers", customerRepository.getAll());
        model.addAttribute("allEmployees", er.getAll());
        model.addAttribute("allPickupLocations", pr.getAll());
        model.addAttribute("carById",carRepository.getSingleById(lr.getSingleById(25).getCarId()));
        model.addAttribute("customerById", customerRepository.getSingleById(lr.getSingleById(25).getCustomerId()));
        model.addAttribute("employeeById", er.getSingleById(lr.getSingleById(25).getEmployeeId()));
        model.addAttribute("pickupLocationId", pr.getSingleById(lr.getSingleById(25).getPickupLocationId()));


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

    @PostMapping("/edit-lease-update")
    public String leaseEdit (HttpSession session, WebRequest dataFromForm, Model information){
        LeaseReportRepository lr = new LeaseReportRepository();
        CustomerRepository cr = new CustomerRepository();
        CarRepository carRepo = new CarRepository();
        EmployeeRepository er = new EmployeeRepository();
        PickupLocationRepository pr = new PickupLocationRepository();

        int leaseId = Integer.parseInt(dataFromForm.getParameter("id"));

        if (lr.getSingleById(leaseId).hasLowDeductableInsurance()) {
            information.addAttribute("hasDeductable", "Har afleveringsforsikring");
        } else {
            information.addAttribute("hasDeductable", "Har ikke afleveringsforsikring");
        }

        if (lr.getSingleById(leaseId).hasReturnInsurance()) {
            information.addAttribute("hasReturn", "Har afleveringsforsikring");
        } else {
            information.addAttribute("hasReturn", "Har ikke afleveringsforsikring");
        }

        if (lr.getSingleById(leaseId).isLimited()) {
            information.addAttribute("isLimited", "Limited");
        } else {
            information.addAttribute("isLimited", "Unlimited");
        }



        information.addAttribute("lease", lr.getSingleById(leaseId));
        information.addAttribute("allCars", carRepo.getAll());
        information.addAttribute("allCustomers", cr.getAll());
        information.addAttribute("allEmployees", er.getAll());
        information.addAttribute("allPickupLocations", pr.getAll());
        information.addAttribute("carById",carRepo.getSingleById(lr.getSingleById(leaseId).getCarId()));
        information.addAttribute("customerById", cr.getSingleById(lr.getSingleById(leaseId).getCustomerId()));
        information.addAttribute("employeeById", er.getSingleById(lr.getSingleById(leaseId).getEmployeeId()));
        information.addAttribute("pickupLocationId", pr.getSingleById(lr.getSingleById(leaseId).getPickupLocationId()));

        return "data-registration-edit";
    }


    @GetMapping("/back-to-data-registration")
    public String backToDataRegistration() {
        return "redirect:/data-registration";
    }

    @RequestMapping("delete-lease-report")
    public String tester(HttpSession session, WebRequest dataFromForm){
        System.out.println( "leasereport ID: " + dataFromForm.getParameter("leaseId"));
        int leaseReportId = Integer.parseInt(dataFromForm.getParameter("leaseId"));
        LeaseReportService lrs = new LeaseReportService();
        lrs.removeLeaseReport(leaseReportId);

        return "redirect:/data-registration";
    }

}
