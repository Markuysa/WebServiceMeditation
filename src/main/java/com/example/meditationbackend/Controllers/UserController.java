package com.example.meditationbackend.Controllers;


import com.example.meditationbackend.Models.authModels.USR;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private ArrayList<USR> USERS = new ArrayList<USR>();
    private UserController(){
        USR user = new USR(1L, "User1", "User1", "email1");
        USR user2 = new USR(2L, "User1", "User1", "email1");
        USR user3 = new USR(3L, "User1", "User1", "email1");
        USERS.add(user);
        USERS.add(user2);
        USERS.add(user3);
    }

    @GetMapping
    public List<USR> getAll(){
        return USERS;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('developers:write')")
    public USR getById(@PathVariable Long id){

        return USERS.stream().filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @PostMapping
    public USR create(@RequestBody USR user){
        this.USERS.add(user);
        return user;
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){

        this.USERS.removeIf(user -> user.getId().equals(id));

    }

}
