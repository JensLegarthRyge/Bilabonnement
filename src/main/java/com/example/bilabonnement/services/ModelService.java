package com.example.bilabonnement.services;
import com.example.bilabonnement.models.LeaseReport;
import com.example.bilabonnement.repositories.*;
import org.springframework.ui.Model;

// Mads Bøgh Højer Nielsen
public class ModelService {
    CarRepository carRepo = new CarRepository();
    LeaseReportRepository lrr = new LeaseReportRepository();
    CustomerRepository cr = new CustomerRepository();
    EmployeeRepository er = new EmployeeRepository();
    PickupLocationRepository plr = new PickupLocationRepository();

    public Model fillModel(Model model) {
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
    public Model insertLease(Model model, int id) {
        LeaseReport lr = lrr.getSingleById(id);
        int carId = lr.getCarId();
        int customerId = lr.getCustomerId();
        int employeeId = lr.getEmployeeId();
        int pickupLocationId = lr.getPickupLocationId();
        model.addAttribute("id", id);
        model.addAttribute("carId", carId);
        model.addAttribute("customerId", customerId);
        model.addAttribute("employeeId", employeeId);
        model.addAttribute("pickupLocationId", pickupLocationId);
        model.addAttribute("carChassis", lr.getCarById(carId).getChassisNumber());
        model.addAttribute("customerNameAndId", lr.getCustomerById(customerId).getIdPlusFullName());
        model.addAttribute("employeeNameAndId", lr.getEmployeeById(employeeId).getIdPlusFullName());
        model.addAttribute("hasReturnInsurance", lr.hasReturnInsurance());
        if (lr.hasReturnInsurance() == true) {
            model.addAttribute("textHasReturnInsurance", "Har afleveringsforsikring");
        } else if (lr.hasReturnInsurance() == false){
            model.addAttribute("textHasReturnInsurance", "Har ikke afleveringsforsikring");
        }
        model.addAttribute("hasLowDeductableInsurance", lr.hasLowDeductableInsurance());
        if (lr.hasLowDeductableInsurance() == true) {
            model.addAttribute("textHasLowDeductable", "Har selvrisiko forsikring");
        } else if (lr.hasLowDeductableInsurance() == false) {
            model.addAttribute("textHasLowDeductable", "Har ikke selvrisiko forsiking");
        }
        model.addAttribute("isLimited", lr.isLimited());
        if (lr.isLimited() == true) {
            model.addAttribute("textIsLimited", "Limited");
        } else if (lr.isLimited() == false) {
            model.addAttribute("textIsLimited", "Unlimited");
        }
        model.addAttribute("getPickupLocation", lr.getPickupLocationById(pickupLocationId).getAddressWithId());
        model.addAttribute("startDate", lr.getStartDate());
        model.addAttribute("createdDate", lr.getCreatedDate());
        model.addAttribute("period", lr.getPeriod());

        return model;
    }
}
