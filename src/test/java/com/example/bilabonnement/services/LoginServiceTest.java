package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import repositories.EmployeeTestRepository;
import repositories.LoginServiceTestRepository;

import javax.servlet.http.HttpServletRequestWrapper;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {
    @Test
    void hasAccess(){

        LoginService loginService = new LoginService();
        //Arrange
        boolean expectedTrue = true;
        boolean expectedFalse = false;


        //Act
        ArrayList<Boolean> wrongResults = new ArrayList<>(Arrays.asList(
                loginService.hasAccess("data", 2),
                loginService.hasAccess("data", 3),
                loginService.hasAccess("data", 6),
                loginService.hasAccess("damage", 1),
                loginService.hasAccess("damage", 3),
                loginService.hasAccess("damage", 5),
                loginService.hasAccess("business", 1),
                loginService.hasAccess("business", 2),
                loginService.hasAccess("business", 4)
        )
        );

        ArrayList<Boolean> rightResults = new ArrayList<>(Arrays.asList(
                loginService.hasAccess("data", 1),
                loginService.hasAccess("data", 4),
                loginService.hasAccess("data", 5),
                loginService.hasAccess("damage", 2),
                loginService.hasAccess("damage", 4),
                loginService.hasAccess("damage", 6),
                loginService.hasAccess("business", 3),
                loginService.hasAccess("business", 5),
                loginService.hasAccess("business", 6)
        )
        );

        //Assert
        for (int i = 0; i < wrongResults.size(); i++) {
            assertEquals(expectedTrue, rightResults.get(i));
        }
        for (int i = 0; i < wrongResults.size(); i++) {
            assertEquals(expectedFalse, wrongResults.get(i));
        }

    }


    @Test
    void verifyUserFromLoginDetails() {
        //Getting data
        LoginServiceTestRepository lstr = new LoginServiceTestRepository();
        LoginService ls = new LoginService();
        ArrayList<WebRequest> trueData = lstr.getAllTrueRequests();
        ArrayList<WebRequest> falseData = lstr.getAllFalseRequests();

        //Arrange
        boolean expectedTrue = true;
        boolean expectedFalse = false;


        //Act
        ArrayList<Boolean> trueResults = new ArrayList<>();
        for (WebRequest wr : trueData) {
            trueResults.add(ls.verifyUserFromLoginDetails(wr));
        }

        ArrayList<Boolean> falseResults = new ArrayList<>();
        for (WebRequest wr : falseData) {
            falseResults.add(ls.verifyUserFromLoginDetails(wr));
        }


        //Assert
        for (boolean tr : trueResults) {
            assertEquals(expectedTrue, tr);
        }

        for (boolean fr : falseResults) {
            assertEquals(expectedFalse, fr);
        }


    }
}