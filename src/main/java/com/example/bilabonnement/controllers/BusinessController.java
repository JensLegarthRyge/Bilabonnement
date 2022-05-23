package com.example.bilabonnement.controllers;

import com.example.bilabonnement.repositories.CarRepository;
import com.example.bilabonnement.services.BusinessDevelopmentService;
import com.example.bilabonnement.services.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BusinessController {

    @GetMapping("/business")
    public String businessDevelopment(Model model){
        CarService carService = new CarService();
        carService.updateRentalStatus();

        model.addAttribute("allCars",new CarRepository().getAll());
        model.addAttribute("BusinessDevelopmentService", new BusinessDevelopmentService());
        return "business-development";
    }


}
