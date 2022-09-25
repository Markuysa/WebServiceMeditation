package com.example.meditationbackend.Models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name" )
    private String name;
    @Column(name = "Login")
    private String login;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status Status;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Roles Role;


}
