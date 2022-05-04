package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Employee;
import org.junit.jupiter.api.Test;
import repositories.EmployeeTestRepository;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {
    @Test
    void verifyUserFromLoginDetails(){
        //Arrange
        EmployeeTestRepository etr = new EmployeeTestRepository();
        LoginService ls = new LoginService();

        //Act
        //boolean expectedLoginSuccess = ls.verifyUserFromLoginDetails(3,"mbhxluna1998",etr.getAll());
        //boolean expectedLoginFail = ls.verifyUserFromLoginDetails(3,"jegtagerfejl",etr.getAll());

        //Assert
        //assertTrue(expectedLoginSuccess);
        //assertFalse(expectedLoginFail);
    }


}