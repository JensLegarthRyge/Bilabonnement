package com.example.bilabonnement.controllers;

import com.example.bilabonnement.repositories.CarRepository;
import com.example.bilabonnement.services.BusinessDevelopmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BusinessController {

    @GetMapping("/business")
    public String businessDevelopment(Model model){
        model.addAttribute("allCars",new CarRepository().getAll());
        model.addAttribute("BusinessDevelopmentService", new BusinessDevelopmentService());
        return "business-development";
    }


}
