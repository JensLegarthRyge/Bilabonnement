package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.*;
import com.example.bilabonnement.services.LeaseReportService;
import com.example.bilabonnement.services.LoginService;

import com.example.bilabonnement.services.CSVFileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class DataRegistrationController {
    LoginService ls = new LoginService();
    LeaseReportService lrs = new LeaseReportService();

    @GetMapping("/data-registration")
    public String dataRegistration(HttpSession session, Model model) {
        // TODO: 5/11/2022  TEST REPLACE FOR PROD
        if(!ls.hasAccess("data", (int) (session.getAttribute("accessFeatures")))){
            return "redirect:/no-access";
        }
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

        LeaseReport report = new LeaseReport();
        LeaseReportRepository lr = new LeaseReportRepository();
        EmployeeRepository er = new EmployeeRepository();
        PickupLocationRepository pr = new PickupLocationRepository();
        ArrayList<LeaseReport> test = new ArrayList<>(lr.getAll());

        model.addAttribute("updateLease", report);
        model.addAttribute("allLeaseReports",lr.getAll());
        model.addAttribute("allPickupLocations",pr.getAll());
        model.addAttribute("allEmployees", er.getAll());



        return "data-registration";
    }

    @PostMapping("/edit-lease-update")
    public String updateLease(WebRequest dataFromForm, @ModelAttribute("updateLease") LeaseReport report) {
        int id = Integer.parseInt(dataFromForm.getParameter("lease-id"));
        int carId = Integer.parseInt(dataFromForm.getParameter("car-chassis"));
        int customerId = Integer.parseInt(dataFromForm.getParameter("edit-customer-id"));
        int employeeId = Integer.parseInt(dataFromForm.getParameter("employee-id"));
        boolean hasReturnInsurance = Boolean.parseBoolean(dataFromForm.getParameter("edit.return-insurance"));
        boolean hasLowDeductable = Boolean.parseBoolean(dataFromForm.getParameter("edit-has-deductable"));
        boolean isLimited = Boolean.parseBoolean(dataFromForm.getParameter("edit-is-limited"));
        int pickupLocationId = Integer.parseInt(dataFromForm.getParameter("edit-pickup-address"));
        LocalDate startDate = LocalDate.parse(dataFromForm.getParameter("start-date"));
        LocalDate createdDate = LocalDate.parse(dataFromForm.getParameter("edit-created-date"));
        int period = Integer.parseInt(dataFromForm.getParameter("edit-period"));



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

    @RequestMapping("/list")
    public String listOfId (HttpSession session, WebRequest dataFromForm, Model idList) {

        return "data-registration";
    }

    @GetMapping("/back-to-data-registration")
    public String backToDataRegistration() {
        return "redirect:/data-registration";
    }

    @RequestMapping("delete-lease-report")
    public String tester(HttpSession session, WebRequest dataFromForm){
        int leaseReportId = Integer.parseInt(dataFromForm.getParameter("leaseId"));
        lrs.removeLeaseReport(leaseReportId);
        return "redirect:/data-registration";
    }

}
