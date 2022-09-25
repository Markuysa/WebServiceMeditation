package com.example.meditationbackend.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class USR {

    private Long id;
    private String firstName;
    private String login;
    private String email;

}


