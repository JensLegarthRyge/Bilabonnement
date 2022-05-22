package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Employee;
import com.example.bilabonnement.repositories.EmployeeRepository;
import org.springframework.web.context.request.WebRequest;

import java.net.http.HttpRequest;

public class EmployeeService {

    public void createNewEmployee(WebRequest dataFromForm){
        EmployeeRepository er = new EmployeeRepository();
        try{
            String firstName = dataFromForm.getParameter("firstName");
            String lastName = dataFromForm.getParameter("lastName");
            String password = dataFromForm.getParameter("password");
            int accessRights = Integer.parseInt(dataFromForm.getParameter("accessRights"));
            boolean isAdmin = dataFromForm.getParameter("isAdmin") != null ? true : false;
            String email = dataFromForm.getParameter("email");

            er.create(new Employee(firstName, lastName, password, accessRights, isAdmin, email));

        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Employee not created");
        }

    }
}
