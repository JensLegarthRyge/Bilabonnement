package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Customer;
import com.example.bilabonnement.models.Employee;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;
import java.sql.*;
import java.util.ArrayList;

//Jens Legarth Ryge, Johannes Forsting og Mads Bøgh Højer Nielsen

public class EmployeeRepository implements CRUDInterface<Employee> {
    Connection connection = DatabaseConnectionManager.getConnection();

    @Override
    public boolean create(Employee entity){

        String firstName = entity.getFirstName();
        String lastName = entity.getLastName();
        String password = entity.getPassword();
        int isAdmin = 1;
        if(!entity.isAdmin()){
            isAdmin = 0;
        }
        int accessFeatures = entity.getAccessFeatures();
        String email = entity.getEmail();

        String query = "INSERT INTO `bilabonnement`.`employees` (`first_name`, `last_name`, `password`, `is_admin`, `access_features`, `email`) " +
                "VALUES ('"+firstName+"', '"+lastName+"', '"+password+"', '"+isAdmin+"', '"+accessFeatures+"', '"+email+"');";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.executeUpdate();
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public ArrayList<Employee> getAll() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM employees AS e WHERE e.employee_id IS NOT NULL");

            while(rs.next()){
                int id = rs.getInt("employee_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String password = rs.getString("password");
                boolean isAdmin = rs.getInt("is_admin") != 0;
                int accessFeatures = rs.getInt("access_features");
                String email = rs.getString("email");
                employees.add(new Employee(id,firstName,lastName,password,accessFeatures,isAdmin,email));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee getSingleById(int id) {
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM employees WHERE employee_id = '"+id+"'");
            rs.next();

            int employeeID = rs.getInt("employee_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String password = rs.getString("password");
            int accessFeature = rs.getInt("access_features");
            boolean isAdmin = rs.getInt("is_admin") != 0;
            String email = rs.getString("email");

            return new Employee(employeeID, firstName, lastName, password, accessFeature, isAdmin, email);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Employee entity) {
        int id = entity.getId();
        String firstName = entity.getFirstName();
        String lastName = entity.getLastName();
        String password = entity.getPassword();
        int isAdmin = 1;
        if(!entity.isAdmin()){
            isAdmin = 0;
        }
        int accessFeatures = entity.getAccessFeatures();
        String email = entity.getEmail();

        String query = "SELECT * FROM employees AS e WHERE e.employee_id = '" + id + "'";

        String query2 = "UPDATE employees SET first_name='" + firstName + "' , " +
                "last_name='" + lastName + "' , " +
                "password='" + password + "' , " +
                "is_admin='" + isAdmin + "' , " +
                "access_features='" + accessFeatures + "' ," +
                "email='" + email + "'" +
                "WHERE employee_id='" + id + "'";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.executeUpdate(query2);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM employees WHERE employee_id='"+id+"';";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
