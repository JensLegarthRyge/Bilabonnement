package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Customer;
import com.example.bilabonnement.repositories.interfaces.CRUDInterface;
import java.sql.*;
import java.util.ArrayList;

//Mads Bøgh Højer Nielsen

public class CustomerRepository implements CRUDInterface<Customer> {
    Connection connection = DatabaseConnectionManager.getConnection();

    @Override
    public boolean create(Customer entity) {

        String firstName = entity.getFirstName();
        String lastName = entity.getLastName();
        String address = entity.getAddress();
        int zipCode = entity.getZipCode();
        String email = entity.getEmail();
        String mobile = entity.getMobile();
        long cpr = entity.getCprNumber();
        long regNum = entity.getRegistrationNumber();
        int accountNum = entity.getAccountNumber();


        String query = "INSERT INTO `bilabonnement`.`customers` (`first_name`, `last_name`, `address`, `zip_`, `email`, `mobile`, `cpr_number`, `reg_number`, `account_number`) " +
                " VALUES ('"+firstName+"', '"+lastName+"', '"+address+"', '"+zipCode+"', '"+email+"', '"+mobile+"', '"+cpr+"', '"+regNum+"', '"+accountNum+"');";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.executeUpdate();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public ArrayList<Customer> getAll() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM customers AS e WHERE e.customer_id IS NOT NULL");

            while(rs.next()){
                int id = rs.getInt("customer_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String address = rs.getString("address");
                int zipCode = rs.getInt("zip_code");
                String email = rs.getString("email");
                String mobile = rs.getString("mobile");
                long cpr = rs.getLong("cpr_number");
                long regNum = rs.getLong("reg_number");
                int accountNum = rs.getInt("account_number");
                customers.add(new Customer(id,firstName,lastName,address,zipCode,email,mobile,cpr,regNum,accountNum));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer getSingleById(int id) {
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM customers WHERE customer_id = '"+id+"'");
            rs.next();

            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String address = rs.getString("address");
            int zipCode = rs.getInt("zip_code");
            String email = rs.getString("email");
            String mobile = rs.getString("mobile");
            long cpr = rs.getLong("cpr_number");
            long regNum = rs.getLong("reg_number");
            int accountNum = rs.getInt("account_number");


            return new Customer(id, firstName, lastName, address, zipCode, email, mobile,cpr,regNum,accountNum);
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(Customer entity) {
        int id = entity.getId();
        String firstName = entity.getFirstName();
        String lastName = entity.getLastName();
        String address = entity.getAddress();
        int zipCode = entity.getZipCode();
        String email = entity.getEmail();
        String mobile = entity.getMobile();
        long cpr = entity.getCprNumber();
        long regNum = entity.getRegistrationNumber();
        int accountNum = entity.getAccountNumber();

        String query = "SELECT * FROM customers AS e WHERE e.customer_id = '" + id + "'";

        String query2 = "UPDATE customers SET first_name='" + firstName + "' , " +
                "last_name='" + lastName + "' , " +
                "address='" + address + "' , " +
                "zip_code='" + zipCode + "' , " +
                "email='" + email + "' ," +
                "mobile='" + mobile + "' ," +
                "cpr_number='" + cpr + "' ," +
                "reg_number='" + regNum + "' ," +
                "account_number='" + accountNum + "'" +
                "WHERE customer_id='" + id + "'";
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
        String query = "DELETE FROM customers WHERE customer_id='"+id+"';";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
