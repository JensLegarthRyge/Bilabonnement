package com.example.bilabonnement.controllers;

import com.example.bilabonnement.repositories.CarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BusinessController {

    @GetMapping("/business")
    public String businessDevelopment(Model carModel){
        CarRepository cr = new CarRepository();
        carModel.addAttribute("allCars",cr.getAll());
        return "business-development";
    }


}
