package com.example.bilabonnement.controllers;
import com.example.bilabonnement.models.Employee;
import com.example.bilabonnement.services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;


@Controller
public class IndexController {

    LoginService ls = new LoginService();


    //Jens Legart Ryge
    @RequestMapping("/")
    public String frontPage(Model loginVerification, @RequestParam(name="status") Optional<String> message, HttpSession session) {
        if(session.getAttribute("userId") != null){
            return "logged-in-frontpage";
        }
        if(message.isPresent()){
            loginVerification.addAttribute("loginerror","Vi kunne ikke finde en bruger med det angivne " +
                    "brugernavn og adgangskode");
        }
        return "index";
    }

    //Jens Legarth Ryge
    @PostMapping("/attempt-login")
    public String loggedInFrontpage(WebRequest request, HttpSession session){
        if(ls.verifyUserFromLoginDetails(request)){
            Employee currentEmp = ls.getEmployee(request.getParameter("email"));
            session.setAttribute("userId",currentEmp.getId());
            session.setAttribute("accessFeatures", currentEmp.getAccessFeatures());
            session.setAttribute("isAdmin", currentEmp.isAdmin());

            return "logged-in-frontpage";

        } else{
            return "redirect:/?status=not-verified";
        }
    }

    //Mads Nielsen
    @GetMapping("/log-out")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    //Johannes Forsting
    @RequestMapping("back-to-logged-in-frontpage")
    public String backToLoggedInFrontpage(){
        return "logged-in-frontpage";
    }

    @GetMapping("no-access")
    public String noAccess(){
        return "no-access";
    }
}
