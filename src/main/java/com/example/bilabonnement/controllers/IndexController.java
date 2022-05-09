package com.example.bilabonnement.controllers;
import com.example.bilabonnement.models.Employee;
import com.example.bilabonnement.repositories.EmployeeRepository;
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
            return "loggedInFrontpage";
        } else{
            return "redirect:/?status=not-verified";
        }

    }

    @GetMapping("/login-user")
    public String frontpage() {
        return "loggedInFrontpage";
    }

    @PostMapping("/flow")
    public String redirectToChosenSite(WebRequest dataFromForm) {

        String urlToRedirect = dataFromForm.getParameter("selected-url");
        System.out.println(urlToRedirect);
        return "redirect:/" + urlToRedirect;
    }

    @GetMapping("/log-out")
    public String logout() {
        return "redirect:/";
    }
}
