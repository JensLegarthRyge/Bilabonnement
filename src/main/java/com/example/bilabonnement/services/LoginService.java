package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Employee;
import com.example.bilabonnement.repositories.EmployeeRepository;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class LoginService {
    EmployeeRepository er = new EmployeeRepository();

    public boolean verifyUserFromLoginDetails(WebRequest loginForm){
        ArrayList<Employee> allEmployees = er.getAll();
        try{
            int userId = Integer.parseInt(loginForm.getParameter("id"));
            String userPassword = loginForm.getParameter("password");

            for (Employee ce:allEmployees) {
                if (ce.getId() == userId && ce.getPassword().equals(userPassword)){
                    return true;
                }
            }
        } catch (NumberFormatException e){
            System.out.println("Login not validated");
            return false;
        }
        System.out.println("Login not validated");
        return false;
    }


    public Employee getEmployee(String id){
        int intId = Integer.parseInt(id);
        return er.getSingleById(intId);
    }

    public boolean hasAccess(String pageToLogInto, int accessFeatures){

        System.out.println("accessfeatures" + accessFeatures);
        System.out.println("page" + pageToLogInto);
        switch (pageToLogInto){
            case "data":
                if(accessFeatures == 1 || accessFeatures == 4 || accessFeatures == 5 ||accessFeatures == 7){
                    return true;
                }
                break;
            case "damage":
                if(accessFeatures == 2 || accessFeatures == 4 || accessFeatures == 6 ||accessFeatures == 7){
                    return true;
                }
                break;
            case "business":
                if(accessFeatures == 3 || accessFeatures == 5 || accessFeatures == 6 ||accessFeatures == 7){
                    return true;
                }
                break;
        }
        return false;
    }


}
