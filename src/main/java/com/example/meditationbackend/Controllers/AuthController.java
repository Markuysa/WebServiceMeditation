package com.example.meditationbackend.Controllers;

import com.example.meditationbackend.Models.authModels.User;
import com.example.meditationbackend.Services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private UsersService usersService;

    public AuthController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/logout")
    public String getLogPage(){

        return "log";
    }

    @PostMapping
    public String postLogin(){
        
        return "form_2";
    }
    @GetMapping("/login")
    public String getLoginPage(){

        return "form_2";
    }
    @GetMapping("/greeting")
    public String getSuccessPage(){

        return "greeting";
    }

    @GetMapping("/register")
    public String getRegisterPage(){

        return "register";
    }
    @PostMapping("/register")
    public String registerUser(@RequestParam String name,@RequestParam String email
            ,@RequestParam String password,@RequestParam String login){
        usersService.addUser(name,email,password,login);
        return "form_2";
    }
}
