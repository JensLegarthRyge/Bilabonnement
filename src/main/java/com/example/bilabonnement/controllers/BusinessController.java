package com.example.bilabonnement.controllers;

import com.example.bilabonnement.repositories.CarRepository;
import com.example.bilabonnement.services.BusinessDevelopmentService;
import com.example.bilabonnement.services.LoginService;
import com.example.bilabonnement.services.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class BusinessController {

    LoginService ls = new LoginService();
    CarService carService = new CarService();

    @GetMapping("/business")
    public String businessDevelopment(HttpSession session, Model model){
        if(!ls.hasAccess("business", (int) (session.getAttribute("accessFeatures")))){
            return "redirect:/no-access";
        }
        carService.updateRentalStatus();
        model.addAttribute("allCars",new CarRepository().getAll());
        model.addAttribute("BusinessDevelopmentService", new BusinessDevelopmentService());
        return "business-development";
    }

}
