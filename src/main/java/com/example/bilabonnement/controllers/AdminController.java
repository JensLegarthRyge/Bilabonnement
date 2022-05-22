package com.example.bilabonnement.controllers;

import com.example.bilabonnement.repositories.EmployeeRepository;
import com.example.bilabonnement.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import java.net.http.HttpRequest;

@Controller
public class AdminController {
    EmployeeRepository er = new EmployeeRepository();
    @GetMapping("admin")
    public String admin(Model allEmployees){
        allEmployees.addAttribute("allEmployees", er.getAll());
        return "admin";
    }


    @PostMapping("create-new-employee-site")
    public String createNewEmployeeSite(){


        return "new-employee";
    }

    @PostMapping("create-new-employee")
    public String createNewEmployee(WebRequest dataFromForm){
        EmployeeService empService = new EmployeeService();
        empService.createNewEmployee(dataFromForm);

        return "redirect:/admin";
    }

}
