package com.example.bilabonnement.controllers;
import com.example.bilabonnement.services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class IndexController {

    LoginService loginService = new LoginService();

    //Vores indeks side
    @GetMapping("/")
    public String frontPage(Model loginVerification, @RequestParam(name="status") Optional<String> message) {
        if(message.isPresent()){
            loginVerification.addAttribute("loginerror","Vi kunne ikke finde en bruger med det angivne " +
                    "brugernavn og adgangskode");
        }
        return "index";
    }

    @PostMapping("/attempt-login")
    public String loggedInFrontpage(WebRequest request, HttpSession session){
        if(loginService.verifyUserFromLoginDetails(request)){
            session.setAttribute("userId",request.getParameter("id"));
            return "logged-in-frontpage";
        } else{
            return "redirect:/?status=not-verified";
        }
    }

    @PostMapping("/admin")
    public String redirectToAdmin(WebRequest dataFromForm, HttpSession session) {
        return "admin";
    }

    @PostMapping("/business-development")
    public String redirectToBusinessDevelopment(WebRequest dataFromForm, HttpSession session) {
        return "business-development";
    }

    @PostMapping("/data-registration")
    public String redirectToDataRegistration(WebRequest dataFromForm, HttpSession session) {
        return "data-registration";
    }

    @PostMapping("/damage-and-maintenance")
    public String redirectToDamageAndMaintenance(WebRequest dataFromForm, HttpSession session) {
        return "damage-and-maintenance";
    }

    @GetMapping("/log-out")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
