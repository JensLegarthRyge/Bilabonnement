package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.repositories.CarTestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

@Controller
public class DataRegistrationController {

    @GetMapping("/data-registration")
    public String dataRegistration(HttpSession session, Model leaseModel) {
        //TEST REPLACE FOR PROD
        LeaseTestRepository lrt = new LeaseTestRepository();


        leaseModel.addAttribute("allLeaseReports",lrt.getAll());

        return "data-registration";
    }

    @PostMapping("/get-upload")
    public String getUpload(@RequestParam("registration-file") MultipartFile file) throws IOException {
        byte[] tmp = file.getBytes();

        for (int i = 0; i < tmp.length; i++) {
            System.out.println(tmp[i]);

        }

        String decoded = new String(tmp, StandardCharsets.UTF_8);


        FileOutputStream fos = new FileOutputStream("src/main/resources/static/csvFiles/temp");
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        CSVWriter writer = new CSVWriter(osw);
        String[] row = {decoded};

        writer.writeNext(row);
        writer.close();
        osw.close();

        return "redirect:/data-registration";
    }


}
