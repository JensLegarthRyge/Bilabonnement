package com.example.bilabonnement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataRegistrationController {

    @GetMapping("/registration")
    public String dataRegistration() {
        return "data-registration";
    }
}
