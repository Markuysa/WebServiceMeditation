package com.example.meditationbackend.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/log")
    public String getLogPage(){

        return "log";
    }

    @PostMapping
    public String registation(){
        
        return "login";
    }
    @GetMapping("/login")
    public String getLoginPage(){

        return "login";
    }
    @GetMapping("/greeting")
    public String getSuccessPage(){

        return "greeting";
    }

}
