package com.example.bilabonnement.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    //Vores indeks side
    @GetMapping("/")
    public String frontPage() {
       return "index";
    }

    @GetMapping("/login-user")
    public String loggedInFrontpage() {

        return "loggedInFrontpage";
    }

    @PostMapping("/flow")
    public String redirectToChosenSite(WebRequest dataFromForm) {

        String urlToRedirect = dataFromForm.getParameter("selected-url");
        System.out.println(urlToRedirect);
        return "redirect:/" + urlToRedirect;
    }
}
