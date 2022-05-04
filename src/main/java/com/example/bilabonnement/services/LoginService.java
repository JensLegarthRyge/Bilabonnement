package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Employee;
import com.example.bilabonnement.repositories.EmployeeRepository;
import org.springframework.web.context.request.WebRequest;

import java.text.ParseException;
import java.util.ArrayList;

public class LoginService {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    public boolean verifyUserFromLoginDetails(WebRequest loginForm){
        ArrayList<Employee> allEmployees = employeeRepository.getAll();

        try{
            int userId = Integer.parseInt(loginForm.getParameter("userId"));
            String userPassword = loginForm.getParameter("userPassword");

            for (Employee ce:allEmployees) {
                if (ce.getId() == userId && ce.getPassword().equals(userPassword)){
                    return true;
                }
            }
        } catch (NumberFormatException e){
            return false;
        }
        return false;
    }
}
