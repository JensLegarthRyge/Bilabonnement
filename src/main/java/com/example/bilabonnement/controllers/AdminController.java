package com.example.bilabonnement.controllers;

import com.example.bilabonnement.repositories.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class AdminController {
    EmployeeRepository er = new EmployeeRepository();
    @GetMapping("admin")
    public String admin(Model allEmployees){
        allEmployees.addAttribute("allEmployees", er.getAll());
        return "admin";
    }


    @PostMapping("create-new-employee")
    public String createNewEmployee(){
        System.out.println("in create new employee");

        return "redirect:/admin";
    }

}
