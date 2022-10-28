package com.example.meditationbackend.Controllers;


import com.example.meditationbackend.Models.authModels.User;
import com.example.meditationbackend.Services.UsersService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UsersService usersService;
    @GetMapping("/profile")
    public String getProfile(){

        return "userProfile";
    }
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/getall")
    public List<User> getAll(){

        return usersService.getUsers();
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasPermission('developers:write')")
    public Optional<User> getById(@PathVariable Long id){
        return usersService.getById(id);

    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        usersService.deleteById(id);

    }

}
