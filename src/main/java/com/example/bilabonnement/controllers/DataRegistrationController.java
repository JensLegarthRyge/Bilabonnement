package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.repositories.CarTestRepository;
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
    public String dataRegistration(HttpSession session, Model carModel) {
        //TEST REPLACE FOR PROD
        CarTestRepository ctr = new CarTestRepository();
        ArrayList<Car> allCars = ctr.getAll();

        carModel.addAttribute("allCars",allCars);

        return "data-registration";
    }

    @PostMapping("/get-upload")
    public String getUpload(WebRequest uploadRequest){
        System.out.println(uploadRequest.getParameter("registration-file"));
        return "redirect:/data-registration";
    }


}
