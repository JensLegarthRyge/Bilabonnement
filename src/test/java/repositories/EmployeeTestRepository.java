package repositories;

import com.example.bilabonnement.models.Employee;
import com.example.bilabonnement.models.Enum.AccessFeatures;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;

import java.util.ArrayList;
import java.util.Arrays;

//Jens Legarth Ryge

public class EmployeeTestRepository implements CRUDInterface<Employee> {
    ArrayList<Employee> employees = new ArrayList<>(
            Arrays.asList(
                    new Employee(1,"Jens","Legarth Ryge", "Jense1337"
                            ,1,true,"jens.l.ryge@pol.dk"),
                    new Employee(2,"Johannes","Forsting","johafors4321",
                            4,false,"johannes.forsting@gmail.com"),
                    new Employee(3,"Mads","Bøgh Højer Nielsen", "mbhxluna1998",
                            2,true,"mbhnxluna@gmail.com")
            )
    );


    @Override
    public boolean create(Employee entity) {
        return false;
    }

    @Override
    public ArrayList<Employee> getAll() {
        return employees;
    }


    @Override
    public Employee getSingleById(int id) {
        for (Employee ce:employees) {
            if (ce.getId()==id){
                return ce;
            }
        }
        return null;
    }

    @Override
    public boolean update(Employee entity) {
        return false;
    }

    @Override
    public Employee delete() {
        return null;
    }
}
