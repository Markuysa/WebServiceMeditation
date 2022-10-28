package com.example.meditationbackend.Controllers;


import com.example.meditationbackend.Models.MeditationModel.Meditation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String main_page(){
        return "index";
    }
}
