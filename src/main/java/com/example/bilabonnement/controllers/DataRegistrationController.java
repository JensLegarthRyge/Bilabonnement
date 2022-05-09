package com.example.bilabonnement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class DataRegistrationController {

    @GetMapping("/data-registration")
    public String dataRegistration() {
        return "data-registration";
    }

    @PostMapping("/get-upload")
    public String getUpload(WebRequest uploadRequest){
        System.out.println(uploadRequest.getParameter("registration-file"));
        return "redirect:/data-registration";
    }
}
