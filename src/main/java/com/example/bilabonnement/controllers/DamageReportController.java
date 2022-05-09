package com.example.bilabonnement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DamageReportController {
    @GetMapping("/damage")
    public String damageReport(){

        return "damage-and-maintenance";
    }
}
