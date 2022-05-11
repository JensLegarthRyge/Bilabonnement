package com.example.bilabonnement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DamageReportController {
    @GetMapping("/damage")
    public String damageReport(HttpSession session, Model leaseModel){

        return "damage-and-maintenance";
    }
}
