package com.example.bilabonnement.controllers;

import com.example.bilabonnement.repositories.EmployeeRepository;
import com.example.bilabonnement.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    EmployeeRepository er = new EmployeeRepository();
    EmployeeService empService = new EmployeeService();
    @GetMapping("admin")
    public String admin(HttpSession session, Model allEmployees){
        if (session.getAttribute("isAdmin").toString().equals("false")) {
            return "redirect:/no-access";
        }
        allEmployees.addAttribute("allEmployees", er.getAll());
        return "admin";
    }


    @PostMapping("create-new-employee-site")
    public String createNewEmployeeSite(){


        return "new-employee";
    }

    @PostMapping("create-new-employee")
    public String createNewEmployee(WebRequest dataFromForm){
        empService.createNewEmployee(dataFromForm);

        return "redirect:/admin";
    }

    @PostMapping("edit-employee")
    public String editEmployee(WebRequest dataFromForm, Model model){
        int employeeId = Integer.parseInt(dataFromForm.getParameter("id"));
        model.addAttribute("employee",  er.getSingleById(employeeId));
        return "edit-employee";
    }

    @PostMapping("change-employee")
    public String changeEmployee(WebRequest dataFromForm){
        System.out.println("Change employee pressed");
        empService.changeEmployee(dataFromForm);
        return "redirect:/admin";
    }

    @PostMapping("delete-employee")
    public String deleteEmployee(WebRequest dataFromForm){
        System.out.println("Change employee pressed");
        empService.deleteEmployee(dataFromForm);
        return "redirect:/admin";
    }




}
