package com.example.bilabonnement.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    //Vores indeks side
    @GetMapping("/")
    public String frontPage() {
       return "index";
    }
}
