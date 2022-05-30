package com.example.bilabonnement.services;
import com.example.bilabonnement.repositories.*;
import org.springframework.ui.Model;

public class ModelService {
    static CarRepository carRepo = new CarRepository();
    static LeaseReportRepository lrr = new LeaseReportRepository();
    static CustomerRepository cr = new CustomerRepository();
    static EmployeeRepository er = new EmployeeRepository();
    static PickupLocationRepository plr = new PickupLocationRepository();

    public static Model fillModel(Model model) {
        model.addAttribute("pickupLocationRepository", plr);
        model.addAttribute("employeeRepository",er);
        model.addAttribute("customerRepository",cr);
        model.addAttribute("carRepository",carRepo);
        model.addAttribute("allCars", carRepo.getAll());
        model.addAttribute("allCustomers", cr.getAll());
        model.addAttribute("allLeaseReports",lrr.getAll());
        model.addAttribute("allPickupLocations",plr.getAll());
        model.addAttribute("allEmployees", er.getAll());
        return model;
    }
}
