package com.example.bilabonnement.controllers;
import com.example.bilabonnement.models.Employee;
import com.example.bilabonnement.repositories.EmployeeRepository;
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
            Employee currentEmp = loginService.getEmployee(request.getParameter("id"));
            session.setAttribute("userId",currentEmp.getId());
            session.setAttribute("accessFeatures", currentEmp.getAccessFeatures());
            session.setAttribute("isAdmin", currentEmp.isAdmin());
            System.out.println("isadmin is:" + session.getAttribute("isAdmin"));

            return "logged-in-frontpage";
        } else{
            return "redirect:/?status=not-verified";
        }
    }

    @GetMapping("/log-out")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping("back-to-logged-in-frontpage")
    public String backToLoggedInFrontpage(){

        return "logged-in-frontpage";
    }

    @GetMapping("no-access")
    public String noAccess(){
        return "no-access";
    }
}
