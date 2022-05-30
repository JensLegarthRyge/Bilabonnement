package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Employee;
import com.example.bilabonnement.repositories.EmployeeRepository;
import org.springframework.web.context.request.WebRequest;


//Johannes Forsting
public class EmployeeService {
    EmployeeRepository er = new EmployeeRepository();
    public void createNewEmployee(WebRequest dataFromForm){
        er.create(getEmployee(dataFromForm));
    }

    public void changeEmployee(WebRequest dataFromForm){
        er.update(getEmployee(dataFromForm));
    }

    public void deleteEmployee(WebRequest dataFromForm){
        int employeeId = Integer.parseInt(dataFromForm.getParameter("id"));
        er.delete(employeeId);
    }


    private Employee getEmployee(WebRequest dataFromForm){
        try{
            String firstName = dataFromForm.getParameter("firstName");
            String lastName = dataFromForm.getParameter("lastName");
            String password = dataFromForm.getParameter("password");
            int accessRights = Integer.parseInt(dataFromForm.getParameter("accessFeatures"));
            boolean isAdmin = dataFromForm.getParameter("isAdmin") != null ? true : false;
            String email = dataFromForm.getParameter("email");
            if(dataFromForm.getParameter("employeeId") != null){
                int employeeId = Integer.parseInt(dataFromForm.getParameter("employeeId"));
                Employee currentEmployee = new Employee(employeeId, firstName, lastName, password, accessRights, isAdmin, email);
                return currentEmployee;
            }
            Employee currentEmployee = new Employee(firstName, lastName, password, accessRights, isAdmin, email);
            return currentEmployee;

        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Employee not created");
        }

        return null;
    }

}
